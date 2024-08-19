package com.dbugger.bugtrackingsystem.dao;

import com.dbugger.bugtrackingsystem.entity.Project;
import com.dbugger.bugtrackingsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectDAO {

    public void addProject(Project project) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "INSERT INTO projects (projectID, projectName, startDate, status, managerID) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, project.getProjectID());
        preparedStatement.setString(2, project.getProjectName());
        preparedStatement.setString(3, project.getStartDate());
        preparedStatement.setString(4, project.getStatus());
        preparedStatement.setInt(5, project.getManager().getEmpID());
        preparedStatement.executeUpdate();
        connection.close();
    }

    // Other CRUD operations
}