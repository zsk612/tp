package commands.main;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import profile.ProfileSession;

public class ToProfile extends Command {

    /**
     * Executes redirecting to Profile Menu command from Main Menu.
     *
     * @param args Array of user's input.
     * @return Redirecting to Profile Menu message.
     */
    @Override
    public CommandResult execute(String args) {
        ui.printOpening("Profile Menu...");

        ProfileSession profileSession = new ProfileSession();
        profileSession.run();
        return new CommandResult("", ExecutionResult.OK);
    }
}
