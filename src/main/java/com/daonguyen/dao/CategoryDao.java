package com.daonguyen.dao;

import com.daonguyen.entity.Category;
import com.daonguyen.jdbc.MySqlConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CategoryDao {
	
	private List<Category> categories = null;
	
	public CategoryDao() {
	}
	
	public List<Category> findAllOfCategories() {
		List<Category> categories = new LinkedList<>();

		try {
			Connection connection = MySqlConnector.getConnection();
			String query = "SELECT * FROM category";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
				Category category = new Category();
				category.setId(resultSet.getString("id"));
				category.setName(resultSet.getString("name"));
				category.setDescription(resultSet.getString("description"));
				categories.add(category);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categories;
	}
	
	public Category findCategoryById(String id) {
		try {
			Connection connection = MySqlConnector.getConnection();
			String query = "SELECT * FROM category WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
				Category category = new Category();
				category.setId(resultSet.getString("id"));
				category.setName(resultSet.getString("name"));
				category.setDescription(resultSet.getString("description"));
				return category;
			}

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Category();
	}

	public void add(Category category) {
		try {
			Category existedCategory = findCategoryById(category.getId());

			if(existedCategory.getId() != null) {
				System.out.println("Category with id [" + category.getId() + "] is existed.");
				return;
			}

			Connection connection = MySqlConnector.getConnection();
			String query = "INSERT INTO category VALUES(?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, category.getId());
			statement.setString(2, category.getName());
			statement.setString(3, category.getDescription());

			if(statement.executeUpdate() > 0) {
				System.out.println("Added category id [" + category.getId() + "] successfully");
			} else {
				System.out.println("Failed to insert category id [" + category.getId() + "].");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void edit(Category category) {
		try {
			Connection connection = MySqlConnector.getConnection();
			String query = "UPDATE category SET name = ?, description = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, category.getName());
			statement.setString(2, category.getDescription());
			statement.setString(3, category.getId());

			if(statement.executeUpdate() > 0) {
				System.out.println("Edited category id [" + category.getId() + "] successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remove(String id) {
		try {
			Connection connection = MySqlConnector.getConnection();
			String query = "DELETE FROM category WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);

			if(statement.executeUpdate() > 0) {
				System.out.println("Removed category id [" + id + "] successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
