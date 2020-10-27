package exceptions.diet;

import exceptions.SchwarzeneggerException;

public class InvalidSearchDateException extends SchwarzeneggerException {

    /**
     * Constructs SchwarzeneggerException object inheriting class Exception.
     *
     * @param message Error message.
     */
    public InvalidSearchDateException(String message) {
        super(message);
    }
}
