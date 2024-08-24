package com.bugtracker.model;

import java.util.Date;

public class Bug {
    private int id;
    private String title;
    private String description;
    private String severity;
    private String status;
    private Date createdOn;

    public Bug(int id, String title, String description, String severity, String status, Date createdOn) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.status = status;
        this.createdOn = createdOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Bug [id=" + id + ", title=" + title + ", description=" + description +
                ", severity=" + severity + ", status=" + status + ", createdOn=" + createdOn + "]";
    }
}
