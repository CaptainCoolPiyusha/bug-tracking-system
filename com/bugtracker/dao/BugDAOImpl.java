package com.bugtracker.dao;

import com.bugtracker.model.Bug;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BugDAOImpl implements BugDAO {

    private List<Bug> bugs; // In-memory database for simplicity

    public BugDAOImpl() {
        bugs = new ArrayList<>();
        // Adding some sample bugs
        bugs.add(new Bug(1, "Login Bug", "Error on login", "High", "Open", new Date()));
        bugs.add(new Bug(2, "UI Issue", "Button not responsive", "Medium", "Open", new Date()));
    }

    @Override
    public List<Bug> getBugsByProject(int projectId) {
        // For simplicity, returning all bugs
        return bugs;
    }

    @Override
    public Bug getBugById(int bugId) {
        return bugs.stream()
                .filter(bug -> bug.getId() == bugId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateBugStatus(int bugId, String status) {
        Bug bug = getBugById(bugId);
        if (bug != null) {
            bug.setStatus(status);
            System.out.println("Bug status updated to: " + status);
        } else {
            System.out.println("Bug not found.");
        }
    }
}
