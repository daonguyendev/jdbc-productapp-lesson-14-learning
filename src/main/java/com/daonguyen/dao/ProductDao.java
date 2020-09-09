package com.daonguyen.dao;

import com.daonguyen.entity.Product;
import com.daonguyen.jdbc.MySqlConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class ProductDao {
	
	private List<Product> products = null;
	
	public ProductDao() {
	}

	public List<Product> findAllOfProducts() {
		List<Product> products = new LinkedList<>();

		try {
			Connection connection = MySqlConnector.getConnection();
			String query = "SELECT * FROM product";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getString("id"));
				product.setName(resultSet.getString("name"));
				product.setAmount(Integer.parseInt(resultSet.getString("amount")));
				product.setPrice(Float.parseFloat(resultSet.getString("price")));
				product.setCateId(resultSet.getString("cate_id"));
				products.add(product);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return products;
	}

	public Product findProductById(String id) {
		try {
			Connection connection = MySqlConnector.getConnection();
			String query = "SELECT * FROM product WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
				Product product = new Product();
				product.setId(resultSet.getString("id"));
				product.setName(resultSet.getString("name"));
				product.setAmount(Integer.parseInt(resultSet.getString("amount")));
				product.setPrice(Float.parseFloat(resultSet.getString("price")));
				product.setCateId(resultSet.getString("cate_id"));
				return product;
			}

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new Product();
	}
	
	public void add(Product product) {
		try {
			Product existedProduct = findProductById(product.getId());

			if(existedProduct.getId() != null) {
				System.out.println("Product with id [" + product.getId() + "] is existed.");
				return;
			}

			Connection connection = MySqlConnector.getConnection();
			String query = "INSERT INTO product VALUES(?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, product.getId());
			statement.setString(2, product.getName());
			statement.setInt(3, product.getAmount());
			statement.setFloat(4, product.getPrice());
			statement.setString(5, product.getCateId());

			if(statement.executeUpdate() > 0) {
				System.out.println("Added product id [" + product.getId() + "] successfully");
			} else {
				System.out.println("Failed to insert category id [" + product.getId() + "].");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void edit(Product product) {
		try {
			Connection connection = MySqlConnector.getConnection();
			String query = "UPDATE product SET name = ?, amount = ?, price = ?, cate_id = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, product.getName());
			statement.setInt(2, product.getAmount());
			statement.setFloat(3, product.getPrice());
			statement.setString(4, product.getCateId());
			statement.setString(5, product.getId());

			if(statement.executeUpdate() > 0) {
				System.out.println("Edited product id [" + product.getId() + "] successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remove(String id) {
		try {
			Connection connection = MySqlConnector.getConnection();
			String query = "DELETE FROM product WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);

			if(statement.executeUpdate() > 0) {
				System.out.println("Removed product id [" + id + "] successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
