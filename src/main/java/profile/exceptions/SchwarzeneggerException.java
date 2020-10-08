package profile.exceptions;

import static profile.Constants.MESSAGE_FORMAT;

/**
 * A base class for the checked exceptions in Duke.
 */
public abstract class SchwarzeneggerException extends Exception {

    /**
     * Constructs SchwarzeneggerException object inheriting class Exception.
     *
     * @param message Error message.
     */
    public SchwarzeneggerException(String message) {
        super(String.format(MESSAGE_FORMAT, message));
    }
}