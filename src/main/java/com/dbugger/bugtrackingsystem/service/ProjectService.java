package com.dbugger.bugtrackingsystem.service;

import com.dbugger.bugtrackingsystem.dao.DAOFactory;
import com.dbugger.bugtrackingsystem.dao.ProjectDAO;
import com.dbugger.bugtrackingsystem.entity.Project;
import com.dbugger.bugtrackingsystem.dao.DAOImpl;

import java.sql.SQLException;

public class ProjectService {

    private static ProjectService instance;
    private  ProjectDAO projectDAO;

    private ProjectService() {
        DAOFactory daoFactory = new DAOImpl();
        this.projectDAO = daoFactory.getProjectDAO();
    }

    public static ProjectService getInstance() {
        if (instance == null) {
            instance = new ProjectService();
        }
        return instance;
    }
    public void createProject(Project project) throws SQLException {
        projectDAO.addProject(project);
    }

    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    // Other service methods
}