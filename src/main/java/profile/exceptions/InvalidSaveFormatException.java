package profile.exceptions;

import static profile.Constants.MESSAGE_INVALID_SAVE_FORMAT;

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
