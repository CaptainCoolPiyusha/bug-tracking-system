package com.dbugger.bugtrackingsystem.entity;

import java.util.Objects;

public class Employee {
    private int empID;
    private String name;
    private String email;
    private String password;
    private String role;

    public Employee(){}
    public Employee( int empID, String email, String name, String password, String role) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
        this.empID = empID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empID == employee.empID && Objects.equals(name, employee.name) && Objects.equals(email, employee.email) && Objects.equals(password, employee.password) && Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, name, email, password, role);
    }

    @Override
    public String toString(){
        return "Employee{" +
                "email='" + email + '\'' +
                ", empID=" + empID +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}