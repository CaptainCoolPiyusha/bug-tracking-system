package com.dbugger.bugtrackingsystem.entity;

import com.dbugger.bugtrackingsystem.dao.BugDAO;
import com.dbugger.bugtrackingsystem.dao.ProjectDAO;
import com.dbugger.bugtrackingsystem.entity.Bug;
import com.dbugger.bugtrackingsystem.entity.Project;

import java.sql.SQLException;
import java.util.List;

public class Tester extends Employee {

    public Tester(int empID, String name, String email, String password) {
        super(empID, name, email, password, "Tester");
    }
}
