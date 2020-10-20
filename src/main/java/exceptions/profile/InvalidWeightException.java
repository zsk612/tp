package exceptions.profile;

import exceptions.SchwarzeneggerException;

import static profile.Constants.MESSAGE_INVALID_WEIGHT;

/**
 * Represents exception when input weight is invalid.
 */
public class InvalidWeightException extends SchwarzeneggerException {

    /**
     * Constructs InvalidWeightException object inheriting abstract class SchwarzeneggerException.
     */
    public InvalidWeightException() {
        super(MESSAGE_INVALID_WEIGHT);
    }
}
