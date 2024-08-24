package com.dbugger.bugtrackingsystem.entity;

import java.sql.SQLException;

public class Developer extends Employee {

    public Developer(int empID, String name, String email, String password) {
        super(empID, name, email, password, "Developer");
    }
}

