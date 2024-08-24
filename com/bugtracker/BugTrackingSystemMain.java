package com.bugtracker;

import com.bugtracker.service.BugService;
import com.bugtracker.service.BugServiceImpl;

public class BugTrackingSystemMain {
    public static void main(String[] args) {
        BugService bugService = new BugServiceImpl();

        // Display all bugs
        System.out.println("Bugs for Project 1:");
        bugService.getBugsForProject(1).forEach(System.out::println);

        // View bug details
        System.out.println("\nViewing Bug Details for Bug ID 1:");
        System.out.println(bugService.viewBugDetails(1));

        // Update bug status
        System.out.println("\nUpdating Bug Status for Bug ID 1:");
        bugService.changeBugStatus(1, "Closed");

        // Verify update
        System.out.println("\nViewing Updated Bug Details for Bug ID 1:");
        System.out.println(bugService.viewBugDetails(1));
    }
}
