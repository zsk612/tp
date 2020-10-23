package commands.main;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import profile.ProfileSession;
import ui.CommonUi;

public class ToProfile extends Command {

    CommonUi ui = new CommonUi();

    @Override
    public CommandResult execute(String[] args) {
        ui.showToUser("Entering Profile Session...");

        ProfileSession profileSession = new ProfileSession();
        profileSession.run();
        return new CommandResult("", ExecutionResult.OK);
    }
}
