package com.dbugger.bugtrackingsystem.service;

import com.dbugger.bugtrackingsystem.dao.BugDAO;
import com.dbugger.bugtrackingsystem.dao.DAOFactory;
import com.dbugger.bugtrackingsystem.dao.DeveloperDAO;
import com.dbugger.bugtrackingsystem.dao.ProjectDAO;
import com.dbugger.bugtrackingsystem.entity.Bug;
import com.dbugger.bugtrackingsystem.entity.Developer;
import com.dbugger.bugtrackingsystem.entity.Project;
import com.dbugger.bugtrackingsystem.factory.DAOImpl;

import java.sql.SQLException;
import java.util.List;

public class DeveloperService {

    private static DeveloperService instance;
    private final DeveloperDAO developerDAO;
    private final ProjectDAO projectDAO;
    private final BugDAO bugDAO;

    public DeveloperService() {
        DAOFactory daoFactory = new DAOImpl();
        developerDAO = daoFactory.getDeveloperDAO();
        projectDAO = daoFactory.getProjectDAO();
        bugDAO = daoFactory.getBugDAO();
    }

    public static DeveloperService getInstance() {
        if (instance == null) {
            instance = new DeveloperService();
        }
        return instance;
    }

    public Developer getDeveloperById(int developerId) throws SQLException {
        return developerDAO.getDeveloperById(developerId);
    }

    public void addDeveloper(Developer developer) throws SQLException {
        developerDAO.addDeveloper(developer);
    }

    public void updateDeveloper(Developer developer) throws SQLException {
        developerDAO.updateDeveloper(developer);
    }

    public void deleteDeveloper(int developerId) throws SQLException {
        developerDAO.deleteDeveloper(developerId);
    }

    public List<Project> getAssignedProjects(int developerId) throws SQLException {
        return projectDAO.getProjectsByDeveloperId(developerId);
    }

    public void changeBugStatus(int bugId, String status) throws SQLException {
        Bug bug = bugDAO.getBugById(bugId);
        if (bug != null) {
            bug.setStatus(status);
            bugDAO.updateBug(bug);
        }
    }

    public Project getProjectDetails(int projectId) throws SQLException {
        return projectDAO.getProjectById(projectId);
    }
}