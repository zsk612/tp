package exceptions.profile;

import exceptions.SchwarzeneggerException;

import static profile.Constants.MESSAGE_INVALID_NAME;

/**
 * Represents exception when input name is invalid.
 */
public class InvalidNameException extends SchwarzeneggerException {

    /**
     * Constructs InvalidNameException object inheriting abstract class SchwarzeneggerException.
     */
    public InvalidNameException() {
        super(MESSAGE_INVALID_NAME);
    }
}
