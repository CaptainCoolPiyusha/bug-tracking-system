package com.dbugger.bugtrackingsystem.entity;

import java.util.List;
import java.util.Objects;

public class Project {
    private String projectID;
    private String projectName;
    private String startDate;
    private String status;
    private Employee manager;
    private List<Employee> teamMembers;

    public Project() {
    }
    public Project(Employee manager, String projectID, String projectName, String startDate, String status, List<Employee> teamMembers) {
        this.manager = manager;
        this.projectID = projectID;
        this.projectName = projectName;
        this.startDate = startDate;
        this.status = status;
        this.teamMembers = teamMembers;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Employee> teamMembers) {
        this.teamMembers = teamMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(projectID, project.projectID) && Objects.equals(projectName, project.projectName) && Objects.equals(startDate, project.startDate) && Objects.equals(status, project.status) && Objects.equals(manager, project.manager) && Objects.equals(teamMembers, project.teamMembers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectID, projectName, startDate, status, manager, teamMembers);
    }

    @Override
    public String toString() {
        return "Project{" +
                "manager=" + manager +
                ", projectID='" + projectID + '\'' +
                ", projectName='" + projectName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", status='" + status + '\'' +
                ", teamMembers=" + teamMembers +
                '}';
    }
}