package commands.main;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import diet.dietmanager.DietManager;

public class ToDiet extends Command {

    /**
     * Executes redirecting to Diet Menu command from Main Menu.
     *
     * @param args User's input.
     * @return Redirecting to Diet Menu message.
     */
    @Override
    public CommandResult execute(String args) {
        DietManager dietManager = new DietManager();
        dietManager.start();
        return new CommandResult("", ExecutionResult.OK);
    }
}
