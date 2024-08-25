package com.dbugger.bugtrackingsystem.service.EmpServiceTest;

import com.dbugger.bugtrackingsystem.dao.DAOFactory;
import com.dbugger.bugtrackingsystem.dao.DeveloperDAO;
import com.dbugger.bugtrackingsystem.entity.Developer;
import com.dbugger.bugtrackingsystem.dao.DAOImpl;
import com.dbugger.bugtrackingsystem.service.DeveloperService;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class DeveloperServiceTest {

    private DeveloperService developerService;
    private Connection connection;

    @Before
    public void setUp() throws SQLException {
        // Set up in-memory database
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE Developer (id INT PRIMARY KEY, name VARCHAR(255), email VARCHAR(255), role VARCHAR(255))");
        }

        // Initialize DAO and service
        DAOFactory daoFactory = new DAOImpl(connection);
        DeveloperDAO developerDAO = daoFactory.getDeveloperDAO();
        developerService = DeveloperService.getInstance();
        developerService.setDeveloperDAO(developerDAO); // Inject DAO
    }

    @Test
    public void testRegisterDeveloper() throws SQLException {
        Developer developer = new Developer(1, "Developer Name", "developer@example.com", "Developer");
        developerService.addDeveloper(developer);

        Developer result = developerService.getDeveloperById(1);
        assertNotNull(result);
        assertEquals("Developer Name", result.getName());
    }

    @Test
    public void testGetDeveloperById() throws SQLException {
        Developer developer = new Developer(1, "Developer Name", "developer@example.com", "Developer");
        developerService.addDeveloper(developer);

        Developer result = developerService.getDeveloperById(1);
        assertNotNull(result);
        assertEquals("Developer Name", result.getName());
    }
}
