package src.main.java.com.dbugger.bugtrackingsystem.exception;

public class BugNotFoundException extends RuntimeException {
    public BugNotFoundException(String message) {
        super(message);
    }
}