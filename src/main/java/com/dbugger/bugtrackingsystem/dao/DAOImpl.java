package com.dbugger.bugtrackingsystem.factory;

import com.dbugger.bugtrackingsystem.dao.*;

public class DAOImpl implements DAOFactory {

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