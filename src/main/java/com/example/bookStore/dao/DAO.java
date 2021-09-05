package com.example.bookStore.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    public static Connection connection = null;

    public DAO() {
        String dbUrl =
                "jdbc:mysql://localhost:3306/pttk_bookstore?autoReconnect=true&useSSL=false";
        String dbClass = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(dbClass);
            connection = DriverManager.getConnection(dbUrl, "root", "luatbeo");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
