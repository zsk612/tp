package commands.main;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import diet.dietmanager.DietManager;

public class ToDiet extends Command {

    @Override
    public CommandResult execute(String[] args) {
        DietManager dietManager = new DietManager();
        dietManager.start();
        return new CommandResult("", ExecutionResult.OK);
    }
}
