package com.dbugger.bugtrackingsystem.service.EmpServiceTest;

import com.dbugger.bugtrackingsystem.dao.DAOFactory;
import com.dbugger.bugtrackingsystem.dao.ProjectDAO;
import com.dbugger.bugtrackingsystem.entity.Project;
import com.dbugger.bugtrackingsystem.dao.DAOImpl;
import com.dbugger.bugtrackingsystem.service.ProjectService;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class ProjectServiceTest {

    private ProjectService projectService;
    private Connection connection;

    @Before
    public void setUp() throws SQLException {
        // Set up in-memory database
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        try (Statement stmt = connection.createStatement()) {
            stmt.execute("CREATE TABLE Project (id INT PRIMARY KEY, name VARCHAR(255), description VARCHAR(255))");
        }

        // Initialize DAO and service
        DAOFactory daoFactory = new DAOImpl(connection);
        ProjectDAO projectDAO = daoFactory.getProjectDAO();
        projectService = ProjectService.getInstance();
        projectService.setProjectDAO(projectDAO); // Inject DAO
    }

    @Test
    public void testRegisterProject() throws SQLException {
        Project project = new Project(1, "Project Name", "Project Description");
        projectService.createProject(project);

        Project result = projectService.getProjectById(1);
        assertNotNull(result);
        assertEquals("Project Name", result.getName());
    }

    @Test
    public void testGetProjectById() throws SQLException {
        Project project = new Project(1, "Project Name", "Project Description");
        projectService.createProject(project);

        Project result = projectService.getProjectById(1);
        assertNotNull(result);
        assertEquals("Project Name", result.getName());
    }
}