package com.dbugger.bugtrackingsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://root@localhost:3306/bug_tracking_sys_db";
    private static final String USER = "root";
    private static final String PASSWORD = "sysadmin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}