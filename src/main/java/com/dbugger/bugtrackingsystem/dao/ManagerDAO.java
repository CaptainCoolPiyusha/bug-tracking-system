package com.dbugger.bugtrackingsystem.dao;

import com.dbugger.bugtrackingsystem.entity.ProjectManager;
import com.dbugger.bugtrackingsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDAO {

    // Retrieves a ProjectManager by their ID from the database
    public ProjectManager getManagerById(int managerId) throws SQLException {
        // Establish a connection to the database
        Connection connection = DBConnection.getConnection();

        // SQL query to select a manager with the given employee ID
        String sql = "SELECT * FROM manager WHERE empID = ?";

        // Prepare the SQL statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Set the employee ID parameter in the query
        preparedStatement.setInt(1, managerId);

        // Execute the query and get the result set
        ResultSet resultSet = preparedStatement.executeQuery();

        // Initialize a ProjectManager object to null
        ProjectManager manager = null;

        // If a result is found, create a ProjectManager object from the result set
        if (resultSet.next()) {
            manager = new ProjectManager(
                    resultSet.getInt("empID"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getString("password")
            );
        }

        // Close the database connection
        connection.close();

        // Return the ProjectManager object (or null if not found)
        return manager;
    }

    // Adds a new ProjectManager to the database
    public void addManager(ProjectManager manager) throws SQLException {
        // Establish a connection to the database
        Connection connection = DBConnection.getConnection();

        // SQL query to insert a new manager into the managers table
        String sql = "INSERT INTO testers (empID, name, email, password) VALUES (?, ?, ?, ?)";

        // Prepare the SQL statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Set the parameters for the SQL statement
        preparedStatement.setInt(1, manager.getEmpID());
        preparedStatement.setString(2, manager.getName());
        preparedStatement.setString(3, manager.getEmail());
        preparedStatement.setString(4, manager.getPassword());

        // Execute the update to insert the new manager
        preparedStatement.executeUpdate();

        // Close the database connection
        connection.close();
    }

    // Updates an existing ProjectManager in the database
    public void updateTester(ProjectManager manager) throws SQLException {
        // Establish a connection to the database
        Connection connection = DBConnection.getConnection();

        // SQL query to update an existing manager in the managers table
        String sql = "UPDATE managers SET name = ?, email = ?, password = ? WHERE empID = ?";

        // Prepare the SQL statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Set the parameters for the SQL statement
        preparedStatement.setString(1, manager.getName());
        preparedStatement.setString(2, manager.getEmail());
        preparedStatement.setString(3, manager.getPassword());
        preparedStatement.setInt(4, manager.getEmpID());

        // Execute the update to modify the manager's information
        preparedStatement.executeUpdate();

        // Close the database connection
        connection.close();
    }

    // Deletes a ProjectManager from the database by their ID
    public void deleteManager(int managerId) throws SQLException {
        // Establish a connection to the database
        Connection connection = DBConnection.getConnection();

        // SQL query to delete a manager from the managers table by employee ID
        String sql = "DELETE FROM managers WHERE empID = ?";

        // Prepare the SQL statement
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // Set the employee ID parameter for the SQL statement
        preparedStatement.setInt(1, managerId);

        // Execute the update to delete the manager
        preparedStatement.executeUpdate();

        // Close the database connection
        connection.close();
    }
}
