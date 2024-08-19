package com.dbugger.bugtrackingsystem.service;

import com.dbugger.bugtrackingsystem.dao.ProjectDAO;
import com.dbugger.bugtrackingsystem.entity.Project;

import java.sql.SQLException;

public class ProjectService {
    private ProjectDAO projectDAO = new ProjectDAO();

    public void createProject(Project project) throws SQLException {
        projectDAO.addProject(project);
    }

    // Other service methods
}