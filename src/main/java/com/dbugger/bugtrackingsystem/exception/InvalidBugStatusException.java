package src.main.java.com.dbugger.bugtrackingsystem.exception;

public class InvalidBugStatusException extends RuntimeException {
    public InvalidBugStatusException(String message) {
        super(message);
    }
}