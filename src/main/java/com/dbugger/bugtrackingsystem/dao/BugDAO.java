package com.dbugger.bugtrackingsystem.dao;
import com.dbugger.bugtrackingsystem.entity.Bug;
import com.dbugger.bugtrackingsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        preparedStatement.setInt(6, bug.getCreatedBy());
        preparedStatement.setInt(7, bug.getAssignedTo().getEmpID());
        preparedStatement.setDate(8, new java.sql.Date(bug.getCreatedOn().getTime()));
        preparedStatement.executeUpdate();
        connection.close();
    }
    public List<Bug> getBugsByTesterId(int testerId) throws SQLException {
        List<Bug> bugs = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM bugs WHERE createdBy = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, testerId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Bug bug = new Bug();
            bug.setBugID(String.valueOf(resultSet.getInt("bugID")));
            bug.setTitle(resultSet.getString("title"));
            bug.setDescription(resultSet.getString("description"));
            bug.setSeverityLevel(resultSet.getString("severityLevel"));
            bug.setStatus(resultSet.getString("status"));
            bug.setCreatedBy(resultSet.getInt("createdBy"));
            bug.setCreatedOn(resultSet.getDate("createdOn"));
            // Set other fields as necessary
            bugs.add(bug);
        }
        connection.close();
        return bugs;
    }

    // Other CRUD operations
}
