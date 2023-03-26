package homework.exceptions;

/**
 * @author Virna Stefan Alexandru
 */
public class GenericCustomException extends RuntimeException {
    public GenericCustomException(String errorMessage) {
        super("Error during operation. " + errorMessage);
    }
}