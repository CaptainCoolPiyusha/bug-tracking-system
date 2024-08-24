package com.bugtracker.service;

import com.bugtracker.dao.BugDAO;
import com.bugtracker.dao.BugDAOImpl;
import com.bugtracker.model.Bug;
import java.util.List;

public class BugServiceImpl implements BugService {

    private BugDAO bugDAO;

    public BugServiceImpl() {
        this.bugDAO = new BugDAOImpl();
    }

    @Override
    public List<Bug> getBugsForProject(int projectId) {
        return bugDAO.getBugsByProject(projectId);
    }

    @Override
    public Bug viewBugDetails(int bugId) {
        return bugDAO.getBugById(bugId);
    }

    @Override
    public void changeBugStatus(int bugId, String status) {
        bugDAO.updateBugStatus(bugId, status);
    }
}
