package commands.main;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import profile.ProfileSession;

public class ToProfile extends Command {

    @Override
    public CommandResult execute(String[] args) {
        System.out.println("Entering Profile Session...");

        ProfileSession profileSession = new ProfileSession();
        profileSession.run();
        return new CommandResult("", ExecutionResult.OK);
    }
}
