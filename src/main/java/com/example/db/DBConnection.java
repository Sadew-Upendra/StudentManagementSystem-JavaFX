package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() throws SQLException {
        // Create connection
        connection = DriverManager.getConnection("jdbc:sqlite:student_management.db");
        // Initialize tables if they don't exist
        createTables();
    }

    public static DBConnection getInstance() throws SQLException {
        return (dbConnection == null) ? dbConnection = new DBConnection() : dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }

    private void createTables() {
        String query = "CREATE TABLE IF NOT EXISTS student (" +
                "id TEXT PRIMARY KEY," +
                "name TEXT NOT NULL," +
                "email TEXT UNIQUE NOT NULL," +
                "contact TEXT," +
                "address TEXT" +
                ");";
        
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(query);
            System.out.println("Database tables initialized successfully.");
        } catch (SQLException e) {
            System.err.println("Error initializing database: " + e.getMessage());
        }
    }
}