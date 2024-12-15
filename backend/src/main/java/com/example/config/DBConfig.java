package com.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/smartflow_manager";
    private static final String USER = "root";
    private static final String PASSWORD = "Nexa721Li"; 

    public static Connection getConnection() throws SQLException {
        try {
            // Ensure the MySQL JDBC driver is loaded
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Connection error", e);
        }
    }
}
