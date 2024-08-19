package com.dbugger.bugtrackingsystem.dao;
import com.dbugger.bugtrackingsystem.entity.Bug;
import com.dbugger.bugtrackingsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BugDAO {

    public void addBug(Bug bug) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO bugs (bugID, title, description, severityLevel, status, createdByID, assignedToID, createdOn) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, bug.getBugID());
        preparedStatement.setString(2, bug.getTitle());
        preparedStatement.setString(3, bug.getDescription());
        preparedStatement.setString(4, bug.getSeverityLevel());
        preparedStatement.setString(5, bug.getStatus());
        preparedStatement.setInt(6, bug.getCreatedBy().getEmpID());
        preparedStatement.setInt(7, bug.getAssignedTo().getEmpID());
        preparedStatement.setDate(8, new java.sql.Date(bug.getCreatedOn().getTime()));
        preparedStatement.executeUpdate();
        connection.close();
    }

    // Other CRUD operations
}
