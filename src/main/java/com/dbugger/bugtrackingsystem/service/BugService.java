package com.dbugger.bugtrackingsystem.service;

import com.dbugger.bugtrackingsystem.dao.BugDAO;
import com.dbugger.bugtrackingsystem.dao.DAOFactory;
import com.dbugger.bugtrackingsystem.entity.Bug;
import com.dbugger.bugtrackingsystem.dao.DAOImpl;

import java.sql.SQLException;

public class BugService {

    private BugDAO bugDAO;

    public BugService() {
        DAOFactory daoFactory = new DAOImpl();
        this.bugDAO = daoFactory.getBugDAO();
    }

    public void reportBug(Bug bug) throws SQLException {
        bugDAO.addBug(bug);
    }
}