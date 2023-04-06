package homework.exceptions;

/**
 * @author Virna Stefan Alexandru
 * Custom exception class for file access issues
 */
public class FileAccessException extends RuntimeException {
    public FileAccessException(String errorMessage) {
        super("Could not access file. " + errorMessage);
    }
}