package com.daonguyen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnector {
    private static final String url = "jdbc:mysql://localhost:3306/product_management";
    private static final String username = "root";
    private static final String password = "admin";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find driver for jdbc connection.");
            e.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Could not find database.");
            ex.printStackTrace();
        }
        return null;
    }
}
