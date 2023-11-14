package christmas.model.exception;

public class ProjectException extends IllegalArgumentException {
    private static final String PREFIX = "[ERROR]";

    public ProjectException(String message) {
        super(PREFIX + message);
    }
}
