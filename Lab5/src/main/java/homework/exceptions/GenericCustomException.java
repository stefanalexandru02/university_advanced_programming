package homework.exceptions;

/**
 * @author Virna Stefan Alexandru
 * Custom exception class for generic issues
 */
public class GenericCustomException extends RuntimeException {
    public GenericCustomException(String errorMessage) {
        super("Error during operation. " + errorMessage);
    }
}