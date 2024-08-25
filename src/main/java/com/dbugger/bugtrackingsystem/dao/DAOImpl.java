package com.dbugger.bugtrackingsystem.dao;

import com.dbugger.bugtrackingsystem.dao.*;
import com.dbugger.bugtrackingsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class DAOImpl implements DAOFactory {

    private Connection connection;

    // Constructor with Connection argument
    public DAOImpl(Connection connection) {
        this.connection = connection;
    }

    public DAOImpl() {
        try {
            this.connection = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public BugDAO getBugDAO() {
        return new BugDAO();
    }

    @Override
    public ProjectDAO getProjectDAO() {
        return new ProjectDAO();
    }

    @Override
    public DeveloperDAO getDeveloperDAO() {
        return new DeveloperDAO();
    }

    @Override
    public EmpDAO getEmpDAO() {
        return new EmpDAO();
    }

    @Override
    public TesterDAO getTesterDAO() {
        return new TesterDAO();
    }
}