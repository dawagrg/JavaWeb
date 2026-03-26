package com.learninglog.learninglogproject.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Utility class to handle database connection
public class DBConnection {

    // Database URL (connecting to MySQL database "learninglogs")
    static String URL = "jdbc:mysql://localhost:3306/learninglogs";

    // Database username
    static String USER = "root";

    // Database password
    static String PASSWORD = "1234";

    // Method to get database connection
    public static Connection getConnection() throws SQLException {

        try {
            // Load MySQL JDBC Driver (required for older versions / explicit loading)
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            // Print error if driver is not found
            System.out.println(e.getMessage());
        }

        // Return connection object using DriverManager
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}