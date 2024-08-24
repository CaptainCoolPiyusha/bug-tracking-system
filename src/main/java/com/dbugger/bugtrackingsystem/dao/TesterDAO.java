package com.dbugger.bugtrackingsystem.dao;

import com.dbugger.bugtrackingsystem.entity.Tester;
import com.dbugger.bugtrackingsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesterDAO {

    public Tester getTesterById(int testerId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM testers WHERE empID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, testerId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Tester tester = null;
        if (resultSet.next()) {
            tester = new Tester(
                    resultSet.getInt("empID"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("password")
            );
        }
        connection.close();
        return tester;
    }

    public void addTester(Tester tester) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO testers (empID, name, email, password) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, tester.getEmpID());
        preparedStatement.setString(2, tester.getName());
        preparedStatement.setString(3, tester.getEmail());
        preparedStatement.setString(4, tester.getPassword());
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void updateTester(Tester tester) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "UPDATE testers SET name = ?, email = ?, password = ? WHERE empID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, tester.getName());
        preparedStatement.setString(2, tester.getEmail());
        preparedStatement.setString(3, tester.getPassword());
        preparedStatement.setInt(4, tester.getEmpID());
        preparedStatement.executeUpdate();
        connection.close();
    }

    public void deleteTester(int testerId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "DELETE FROM testers WHERE empID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, testerId);
        preparedStatement.executeUpdate();
        connection.close();
    }
}