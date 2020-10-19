package commands.profile;

import profile.Profile;
import storage.profile.Storage;

/**
 * A base class for command.
 */
public abstract class Command {

    /**
     * Executes a specific command requested by user's input.
     *
     * @param profile User's Profile object.
     * @param storage Storage to save data when required.
     * @return Result of command execution.
     */
    public abstract CommandResult execute(Profile profile, Storage storage);
}
