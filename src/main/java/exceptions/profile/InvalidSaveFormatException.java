package exceptions.profile;

import exceptions.SchwarzeneggerException;

import static ui.profile.ProfileUi.MESSAGE_INVALID_SAVE_FORMAT;

/**
 * Represents exception when there is corruption in data save format.
 */
public class InvalidSaveFormatException extends SchwarzeneggerException {

    /**
     * Constructs InvalidSaveFormatException object inheriting abstract class SchwarzeneggerException.
     */
    public InvalidSaveFormatException(String filePath) {
        super(String.format(MESSAGE_INVALID_SAVE_FORMAT, filePath));
    }

}
