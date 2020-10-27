package exceptions.profile;

import exceptions.SchwarzeneggerException;

import static ui.profile.ProfileUi.MESSAGE_INVALID_CALORIES;

/**
 * Represents exception when input calories is invalid.
 */
public class InvalidCaloriesException extends SchwarzeneggerException {

    /**
     * Constructs InvalidCaloriesException object inheriting abstract class SchwarzeneggerException.
     */
    public InvalidCaloriesException() {
        super(MESSAGE_INVALID_CALORIES);
    }
}
