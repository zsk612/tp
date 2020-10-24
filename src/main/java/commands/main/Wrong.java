package commands.main;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import ui.CommonUi;

import java.util.logging.Level;

public class Wrong extends Command {

    CommonUi ui = new CommonUi();

    /**
     * Notifies user invalid input command.
     *
     * @param args Array of user's input.
     * @return Invalid input command message.
     */
    @Override
    public CommandResult execute(String[] args) {
        ui.showToUser("Sorry! It seems like you've entered an invalid command!");
        logger.log(Level.INFO, "Invalid command");
        return new CommandResult("", ExecutionResult.MISSING);
    }
}
