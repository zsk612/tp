package profile.exceptions;

import static profile.components.Constants.MESSAGE_INVALID_SAVE_FORMAT;

/**
 * Represents exception when there is corruption in data save format.
 */
public class InvalidSaveFormatException extends SchwarzeneggerException {

    /**
     * Constructs InvalidSaveFormatException object inheriting abstract class SchwarzeneggerException.
     *
     * @param encodedLine The specific line in the data file that is causing the error.
     */
    public InvalidSaveFormatException(String encodedLine) {
        super(String.format(MESSAGE_INVALID_SAVE_FORMAT, encodedLine));
    }

}
