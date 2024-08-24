package com.dbugger.bugtrackingsystem;

import com.dbugger.bugtrackingsystem.entity.Employee;
import com.dbugger.bugtrackingsystem.service.EmpService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EmpService empService = EmpService.getInstance();
        try {

//            Employee employee = new Employee(1, "piyusha@gmail.com", "Piyusha", "test123", "Tester");
//            empService.registerEmployee(employee);

//            Employee employee = new Employee(2, "avishek@gmail.com", "Avishek", "admin123", "ProjectManager");
//            empService.registerEmployee(employee);

//            Employee employee = new Employee(3, "anubhav@gmail.com", "Anubhav", "dev123", "Developer");
//            empService.registerEmployee(employee);



            Employee loggedInEmployee = empService.login(1, "password123");
            if (loggedInEmployee != null) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid credentials!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}