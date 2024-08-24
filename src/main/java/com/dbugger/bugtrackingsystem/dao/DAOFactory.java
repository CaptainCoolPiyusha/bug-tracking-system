package com.dbugger.bugtrackingsystem.dao;

import com.dbugger.bugtrackingsystem.dao.BugDAO;
import com.dbugger.bugtrackingsystem.dao.ProjectDAO;
import com.dbugger.bugtrackingsystem.dao.DeveloperDAO;
import com.dbugger.bugtrackingsystem.dao.EmpDAO;
import com.dbugger.bugtrackingsystem.dao.TesterDAO;

public interface DAOFactory {
    BugDAO getBugDAO();
    EmpDAO getEmpDAO();
    ProjectDAO getProjectDAO();
    TesterDAO getTesterDAO();
    DeveloperDAO getDeveloperDAO();
}
