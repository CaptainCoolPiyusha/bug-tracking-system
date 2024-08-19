package com.dbugger.bugtrackingsystem.service;

import com.dbugger.bugtrackingsystem.dao.EmpDAO;
import com.dbugger.bugtrackingsystem.entity.Employee;

import java.sql.SQLException;

public class EmpService {

    private EmpDAO empDAO = new EmpDAO();

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
