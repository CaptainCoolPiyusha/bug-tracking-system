package com.bugtracker.dao;

import com.bugtracker.model.Bug;
import java.util.List;

public interface BugDAO {
    List<Bug> getBugsByProject(int projectId);
    Bug getBugById(int bugId);
    void updateBugStatus(int bugId, String status);
}
