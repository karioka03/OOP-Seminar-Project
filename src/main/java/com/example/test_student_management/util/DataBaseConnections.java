package com.example.test_student_management.util;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnections {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                
                Dotenv dotenv = Dotenv.load();
                
                String url = dotenv.get("postgresql://postgres.dnrfnvqfngxcakdnvcko:[YOUR-PASSWORD]@aws-1-ap-northeast-1.pooler.supabase.com:6543/postgres");
                String user = dotenv.get("postgres.dnrfnvqfngxcakdnvcko");
                String password = dotenv.get("#midorima1234");

                // 2. Establish the connection
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Successfully connected to Supabase!");
                
                System.out.println("DEBUG - URL Loaded: " + url);
                System.out.println("DEBUG - User Loaded: " + user);
                System.out.println("DEBUG - Password Loaded: " + (password != null ? "YES (Not Empty)" : "NULL/EMPTY"));
                
            } catch (SQLException e) {
                System.err.println("Database connection failed!");
                e.printStackTrace();
            }
        }
        return connection;
    }
}