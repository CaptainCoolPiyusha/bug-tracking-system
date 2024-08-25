package com.dbugger.bugtrackingsystem.dao;

import com.dbugger.bugtrackingsystem.entity.Bug;
import com.dbugger.bugtrackingsystem.entity.Project;
import com.dbugger.bugtrackingsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public List<Project> getProjectsByTesterId(int testerId) throws SQLException {
        List<Project> projects = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT p.* FROM projects p JOIN project_assignments pa ON p.projectID = pa.projectID WHERE pa.testerID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, testerId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Project project = new Project();
            project.setProjectID(resultSet.getString("projectID"));
            project.setProjectName(resultSet.getString("projectName"));
            project.setStartDate(resultSet.getString("startDate"));
            project.setStatus(resultSet.getString("status"));
            // Set other fields as necessary
            projects.add(project);
        }
        connection.close();
        return projects;
    }

    public List<Project> getProjectsByDeveloperId(int developerId) throws SQLException {
        List<Project> projects = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT p.* FROM projects p JOIN project_assignments pa ON p.projectID = pa.projectID WHERE pa.developerID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, developerId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Project project = new Project();
            project.setProjectID(resultSet.getString("projectID"));
            project.setProjectName(resultSet.getString("projectName"));
            project.setStartDate(resultSet.getString("startDate"));
            project.setStatus(resultSet.getString("status"));
            // Set other fields as necessary
            projects.add(project);
        }
        connection.close();
        return projects;
    }
    public Project getProjectById(int projectId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String sql = "SELECT * FROM projects WHERE projectID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, projectId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Project project = null;
        if (resultSet.next()) {
            project = new Project();
            project.setProjectID(resultSet.getString("projectID"));
            project.setProjectName(resultSet.getString("projectName"));
            project.setStartDate(resultSet.getString("startDate"));
            project.setStatus(resultSet.getString("status"));
            // Set other fields as necessary
        }
        connection.close();
        return project;
    }

    // Other CRUD operations
}