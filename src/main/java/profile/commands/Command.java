package profile.commands;

import profile.components.Profile;
import profile.storage.Storage;

import java.util.logging.Logger;

/**
 * A base class for command.
 */
public abstract class Command {
    protected Logger logger = Logger.getLogger("java.profile.commands");

    /**
     * Executes a specific command requested by user's input.
     *
     * @param profile User's Profile object.
     * @param storage Storage to save data when required.
     * @return Result of command execution.
     */
    public abstract CommandResult execute(Profile profile, Storage storage);
}
