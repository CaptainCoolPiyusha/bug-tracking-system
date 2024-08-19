package com.dbugger.bugtrackingsystem.service;

import com.dbugger.bugtrackingsystem.dao.BugDAO;
import com.dbugger.bugtrackingsystem.entity.Bug;

import java.sql.SQLException;

public class BugService {

    private BugDAO bugDAO = new BugDAO();

    public void reportBug(Bug bug) throws SQLException {
        bugDAO.addBug(bug);
    }
}