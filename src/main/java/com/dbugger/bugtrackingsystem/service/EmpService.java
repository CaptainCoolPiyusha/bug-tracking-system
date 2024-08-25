package com.dbugger.bugtrackingsystem.service;

import com.dbugger.bugtrackingsystem.dao.DAOFactory;
import com.dbugger.bugtrackingsystem.dao.EmpDAO;
import com.dbugger.bugtrackingsystem.entity.Employee;
import com.dbugger.bugtrackingsystem.dao.DAOImpl;

import java.sql.SQLException;

public class EmpService {

    private static EmpService instance;
    private  EmpDAO empDAO ;

    private EmpService() {
        DAOFactory daoFactory = new DAOImpl();
        this.empDAO = daoFactory.getEmpDAO();
    }

    public static EmpService getInstance() {
        if (instance == null) {
            instance = new EmpService();
        }
        return instance;
    }
    public void setEmpDAO(EmpDAO empDAO) {
        this.empDAO = empDAO;
    }

    public void registerEmployee(Employee employee) throws SQLException {
        empDAO.addEmployee(employee);
    }

    public Employee login(int empID, String password) throws SQLException {
        Employee employee = empDAO.getEmployeeById(empID);
        if (employee != null && employee.getPassword().equals(password)) {
            return employee;
        }
        return null;
    }

    // Other service methods
}
