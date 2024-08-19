package com.dbugger.bugtrackingsystem.dao;

import com.dbugger.bugtrackingsystem.entity.Employee;
import com.dbugger.bugtrackingsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpDAO {

    public void addEmployee(Employee employee) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO employee (empID, name, email, password, role) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, employee.getEmpID());
        preparedStatement.setString(2, employee.getName());
        preparedStatement.setString(3, employee.getEmail());
        preparedStatement.setString(4, employee.getPassword());
        preparedStatement.setString(5, employee.getRole());
        preparedStatement.executeUpdate();
        connection.close();
    }

    public Employee getEmployeeById(int employeeID) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM employee WHERE empID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, employeeID);
        ResultSet resultSet = preparedStatement.executeQuery();

        Employee employee = null;
        if (resultSet.next()) {
            employee = new Employee();
            employee.setEmpID(resultSet.getInt("empID"));
            employee.setName(resultSet.getString("name"));
            employee.setEmail(resultSet.getString("email"));
            employee.setPassword(resultSet.getString("password"));
            employee.setRole(resultSet.getString("role"));
        }
        connection.close();
        return employee;
    }

    // Other CRUD operations
}

