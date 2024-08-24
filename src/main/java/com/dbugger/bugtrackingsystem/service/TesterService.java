package com.dbugger.bugtrackingsystem.service;

import com.dbugger.bugtrackingsystem.dao.BugDAO;
import com.dbugger.bugtrackingsystem.dao.ProjectDAO;
import com.dbugger.bugtrackingsystem.entity.Bug;
import com.dbugger.bugtrackingsystem.entity.Employee;
import com.dbugger.bugtrackingsystem.entity.Project;

import java.sql.SQLException;
import java.util.List;

public class TesterService {

    private static TesterService instance;
    private BugDAO bugDAO;
    private ProjectDAO projectDAO;

    private TesterService() {
        bugDAO = new BugDAO();
        projectDAO = new ProjectDAO();
    }

    public static TesterService getInstance() {
        if (instance == null) {
            instance = new TesterService();
        }
        return instance;
    }

    public List<Project> getAssignedProjects(int testerId) throws SQLException {
        // Implementation to get projects assigned to the tester
        return projectDAO.getProjectsByTesterId(testerId);
    }

    public void reportBug(int empId, Bug bug) throws SQLException {
        // Implementation to report a new bug
        bug.setCreatedBy(empId);
        bug.setCreatedOn(new java.util.Date());
        bugDAO.addBug(bug);
    }

    public List<Bug> getReportedBugs(int empId) throws SQLException {
        // Implementation to get bugs reported by the tester
        return bugDAO.getBugsByTesterId(empId);
    }
}