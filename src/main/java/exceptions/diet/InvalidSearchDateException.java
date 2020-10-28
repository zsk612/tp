package exceptions.diet;

import exceptions.SchwarzeneggerException;

/**
 * Represents exception when search date is invalid.
 */
public class InvalidSearchDateException extends SchwarzeneggerException {

    /**
     * Constructs InvalidSearchDateException object inheriting class SchwarzeneggerException.
     *
     * @param message Error message.
     */
    public InvalidSearchDateException(String message) {
        super(message);
    }
}
