package homework.exceptions;

/**
 * @author Virna Stefan Alexandru
 */
public class FileAccessException extends RuntimeException {
    public FileAccessException(String errorMessage) {
        super("Could not access file. " + errorMessage);
    }
}