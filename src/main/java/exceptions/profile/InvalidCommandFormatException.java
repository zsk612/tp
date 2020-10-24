package exceptions.profile;

import exceptions.SchwarzeneggerException;

/**
 * Represents exception when command format is invalid.
 */
public class InvalidCommandFormatException extends SchwarzeneggerException {

    /**
     * Constructs InvalidCommandFormatException object inheriting abstract class SchwarzeneggerException.
     *
     * @param command Command with invalid format.
     */
    public InvalidCommandFormatException(String command) {
        super(String.format("%s command format is invalid. Please type \"help\" to see the correct format.",
                command.toUpperCase()));
    }
}
