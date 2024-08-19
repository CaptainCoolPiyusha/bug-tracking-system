package com.dbugger.bugtrackingsystem.entity;

import java.sql.SQLException;

public class Tester extends Employee {

    public Tester(int empID, String name, String email, String password) {
        super(empID, name, email, password, "Tester");
    }

    public void viewAssignedProjects() throws SQLException {
        // Implementation for viewing assigned projects
        // Call the corresponding service method
    }

    public void reportBug(Bug bug) throws SQLException {
        // Implementation for reporting a bug
        // Call the corresponding service method
    }

    public void viewReportedBugs() throws SQLException {
        // Implementation for viewing bugs reported by this tester
        // Call the corresponding service method
    }
}
