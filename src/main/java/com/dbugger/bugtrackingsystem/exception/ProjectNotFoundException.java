package src.main.java.com.dbugger.bugtrackingsystem.exception;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(String message) {
        super(message);
    }
}