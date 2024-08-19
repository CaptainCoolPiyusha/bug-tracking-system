package com.dbugger.bugtrackingsystem.entity;

import java.sql.SQLException;

public class Developer extends Employee {

    public Developer(int empID, String name, String email, String password) {
        super(empID, name, email, password, "Developer");
    }

    public void viewAssignedProjects() throws SQLException {
        // Implementation for viewing assigned projects
        // Call the corresponding service method
    }

    public void markBugAsResolved(Bug bug) throws SQLException {
        // Implementation for marking a bug as resolved
        // Call the corresponding service method
    }

    public void viewAssignedBugs() throws SQLException {
        // Implementation for viewing all bugs assigned to this developer
        // Call the corresponding service method
    }
}

