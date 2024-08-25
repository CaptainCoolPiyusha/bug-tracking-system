package com.dbugger.bugtrackingsystem.entity;

import java.sql.SQLException;
import java.util.List;

public class ProjectManager extends Employee{

    public ProjectManager(int empID, String name, String email, String password) {
        super(empID, name, email, password, "ProjectManager");
    }

//    public void createProject(Project project) throws SQLException {
//        // Implementation for creating a project
//        // Call the corresponding service method
//    }
//
//    public void assignBug(Bug bug, Developer developer) throws SQLException {
//        // Implementation for assigning a bug to a developer
//        // Call the corresponding service method
//    }
//
//    public List<Bug> viewAllBugsForProject(Project project) throws SQLException {
//        // Implementation for viewing all bugs associated with a project
//        // Call the corresponding service method
//        return null;
//    }
}