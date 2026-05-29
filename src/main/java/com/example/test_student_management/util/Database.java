package com.example.test_student_management.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Database {

    // Direct Supabase credentials (bypasses .env loading errors)
    private static final String DB_URL = "jdbc:postgresql://aws-1-ap-northeast-1.pooler.supabase.com:6543/postgres";
    private static final String DB_USER = "postgres.dnrfnvqfngxcakdnvcko";
    private static final String DB_PASSWORD = "#midorima1234"; // ⚠️ Put your secret database password here

    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        // Explicitly register the PostgreSQL driver class to guarantee it initializes
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver not found in classpath!");
            e.printStackTrace();
        }
        
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}