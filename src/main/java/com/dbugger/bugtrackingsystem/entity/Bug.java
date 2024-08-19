package com.dbugger.bugtrackingsystem.entity;

import java.util.Date;
import java.util.Objects;

public class Bug {
    private String bugID;
    private String title;
    private String description;
    private String severityLevel;
    private String status;
    private Employee createdBy;
    private Employee assignedTo;
    private Date createdOn;

    public Bug(Employee assignedTo, String bugID, Employee createdBy, Date createdOn, String description, String severityLevel, String status, String title) {
        this.assignedTo = assignedTo;
        this.bugID = bugID;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.description = description;
        this.severityLevel = severityLevel;
        this.status = status;
        this.title = title;
    }

    public Employee getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Employee assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getBugID() {
        return bugID;
    }

    public void setBugID(String bugID) {
        this.bugID = bugID;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employee createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bug bug = (Bug) o;
        return Objects.equals(bugID, bug.bugID) && Objects.equals(title, bug.title) && Objects.equals(description, bug.description) && Objects.equals(severityLevel, bug.severityLevel) && Objects.equals(status, bug.status) && Objects.equals(createdBy, bug.createdBy) && Objects.equals(assignedTo, bug.assignedTo) && Objects.equals(createdOn, bug.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bugID, title, description, severityLevel, status, createdBy, assignedTo, createdOn);
    }

    @Override
    public String toString() {
        return "Bug{" +
                "assignedTo=" + assignedTo +
                ", bugID='" + bugID + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", severityLevel='" + severityLevel + '\'' +
                ", status='" + status + '\'' +
                ", createdBy=" + createdBy +
                ", createdOn=" + createdOn +
                '}';
    }
}
