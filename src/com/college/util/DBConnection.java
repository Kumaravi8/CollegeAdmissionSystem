package com.college.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/college_db"; // apne DB ka URL yahan dalna
    private static final String USER = "root";      // DB username
    private static final String PASSWORD = "root";  // DB password

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // MySQL JDBC driver load
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
