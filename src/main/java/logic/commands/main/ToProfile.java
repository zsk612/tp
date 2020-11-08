package logic.commands.main;

import logic.commands.Command;
import logic.commands.CommandResult;
import logic.commands.ExecutionResult;
import profile.ProfileSession;

/**
 * A representation of the command for redirecting to Profile Menu from Main Menu.
 */
public class ToProfile extends Command {

    /**
     * Executes redirecting to Profile Menu command from Main Menu.
     *
     * @param args User's input.
     * @return Redirecting to Profile Menu message.
     */
    @Override
    public CommandResult execute(String args) {
        if (!args.isEmpty()) {
            ui.showWarning("\"profile\" command does not take in parameters");
        }

        ProfileSession profileSession = ProfileSession.getInstance();
        profileSession.run();
        return new CommandResult("", ExecutionResult.OK);
    }
}
