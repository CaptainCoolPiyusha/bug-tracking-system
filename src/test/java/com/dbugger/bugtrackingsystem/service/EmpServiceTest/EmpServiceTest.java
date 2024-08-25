package com.dbugger.bugtrackingsystem.service.EmpServiceTest;

import com.dbugger.bugtrackingsystem.dao.DAOFactory;
import com.dbugger.bugtrackingsystem.dao.EmpDAO;
import com.dbugger.bugtrackingsystem.entity.Employee;
import com.dbugger.bugtrackingsystem.dao.DAOImpl;
import com.dbugger.bugtrackingsystem.service.EmpService;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class EmpServiceTest {

    private EmpService empService;
    private Connection connection;

    @Before
    public void setUp() throws SQLException {
        // Set up in-memory database
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE Employee (id INT PRIMARY KEY, email VARCHAR(255), name VARCHAR(255), password VARCHAR(255), role VARCHAR(255))");
        }

        // Initialize DAO and service
        DAOFactory daoFactory = new DAOImpl();
        EmpDAO empDAO = daoFactory.getEmpDAO();
        empService = EmpService.getInstance();
        empService.setEmpDAO(empDAO); // Inject DAO
    }

    @Test
    public void testRegisterEmployee() throws SQLException {
        Employee employee = new Employee(1, "test@example.com", "Test", "password", "Tester");
        empService.registerEmployee(employee);

        Employee result = empService.login(1, "password");
        assertNotNull(result);
        assertEquals("Test", result.getName());
    }

    @Test
    public void testLoginSuccess() throws SQLException {
        Employee employee = new Employee(1, "test@example.com", "Test", "password", "Tester");
        empService.registerEmployee(employee);

        Employee result = empService.login(1, "password");
        assertNotNull(result);
        assertEquals("Test", result.getName());
    }

    @Test
    public void testLoginFailure() throws SQLException {
        Employee result = empService.login(1, "wrongpassword");
        assertNull(result);
    }
}