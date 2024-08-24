package com.dbugger.bugtrackingsystem.dao;

import com.dbugger.bugtrackingsystem.entity.Developer;
import com.dbugger.bugtrackingsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeveloperDAO {

    public Developer getDeveloperById(int developerId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM developers WHERE empID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, developerId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Developer developer = null;
        if (resultSet.next()) {
            developer = new Developer(
                    resultSet.getInt("empID"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("password")
            );
        }
        connection.close();
        return developer;
    }

    public void addDeveloper(Developer developer) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO developers (empID, name, email, password) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, developer.getEmpID());
        preparedStatement.setString(2, developer.getName());
        preparedStatement.setString(3, developer.getEmail());
        preparedStatement.setString(4, developer.getPassword());
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void updateDeveloper(Developer developer) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE developers SET name = ?, email = ?, password = ? WHERE empID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, developer.getName());
        preparedStatement.setString(2, developer.getEmail());
        preparedStatement.setString(3, developer.getPassword());
        preparedStatement.setInt(4, developer.getEmpID());
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void deleteDeveloper(int developerId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "DELETE FROM developers WHERE empID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, developerId);
        preparedStatement.executeUpdate();
        connection.close();
    }
}