package com.bugtracker.service;

import com.bugtracker.model.Bug;
import java.util.List;

public interface BugService {
    List<Bug> getBugsForProject(int projectId);
    Bug viewBugDetails(int bugId);
    void changeBugStatus(int bugId, String status);
}
