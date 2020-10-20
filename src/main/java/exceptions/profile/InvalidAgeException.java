package exceptions.profile;

import exceptions.SchwarzeneggerException;

import static profile.Constants.MESSAGE_INVALID_AGE;
import static profile.Constants.MESSAGE_INVALID_COMMAND_WORD;

/**
 * Represents exception when input age is invalid.
 */
public class InvalidAgeException extends SchwarzeneggerException {

    /**
     * Constructs InvalidAgeException object inheriting abstract class SchwarzeneggerException.
     */
    public InvalidAgeException() {
        super(MESSAGE_INVALID_AGE);
    }
}
