package com.dbugger.bugtrackingsystem.service;

import com.dbugger.bugtrackingsystem.dao.BugDAO;
import com.dbugger.bugtrackingsystem.dao.DAOFactory;
import com.dbugger.bugtrackingsystem.dao.ProjectDAO;
import com.dbugger.bugtrackingsystem.entity.Bug;
import com.dbugger.bugtrackingsystem.entity.Employee;
import com.dbugger.bugtrackingsystem.entity.Project;
import com.dbugger.bugtrackingsystem.dao.DAOImpl;

import java.sql.SQLException;
import java.util.List;

public class ManagerService {

    // Singleton instance of ManagerService
    private static ManagerService instance;

    // DAO objects to interact with the data layer
    private BugDAO bugDAO;
    private ProjectDAO projectDAO;

    // Constructor that initializes DAOs using a factory pattern
    public ManagerService() {
        DAOFactory daoFactory = new com.dbugger.bugtrackingsystem.dao       .DAOImpl();
        bugDAO = daoFactory.getBugDAO();
        projectDAO = daoFactory.getProjectDAO();
    }

    // Singleton method to get the instance of ManagerService
    public static ManagerService getInstance() {
        if (instance == null) {
            instance = new ManagerService();
        }
        return instance;
    }

    // Retrieves a list of projects assigned to a specific tester by tester ID
    public List<Project> getAssignedProjects(int testerId) throws SQLException {
        // Implementation to get projects assigned to the tester
        return projectDAO.getProjectsByTesterId(testerId);
    }

    // Retrieves a list of bugs reported by a specific employee by employee ID
    public List<Bug> getReportedBugs(int empId) throws SQLException {
        // Implementation to get bugs reported by the tester
        return bugDAO.getBugsByTesterId(empId);
    }

    // Assigns a bug to an employee by bug ID and employee object
    public void assignBug(int bugId, Employee employee) throws SQLException {
        Bug bug = bugDAO.getBugById(bugId);
        if (bug != null) {
            bug.setAssignedTo(employee);
            bugDAO.updateBug(bug);
        }
    }

    // Sets the severity level of a bug by bug ID and severity string
    public void setBugSeverity(int bugId, String severity) throws SQLException {
        Bug bug = bugDAO.getBugById(bugId);
        if (bug != null) {
            bug.setSeverityLevel(severity);
            bugDAO.updateBug(bug);
        }
    }

    // Tracks a bug's status by bug ID
    public void trackBug(int bugId, String status) throws SQLException {
        Bug bug = bugDAO.getBugById(bugId);
        if (bug != null) {
            System.out.println(bug.getStatus());
        }
    }
}
