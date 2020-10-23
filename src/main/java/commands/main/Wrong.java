package commands.main;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import logger.SchwarzeneggerLogger;
import ui.CommonUi;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Wrong extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();
    CommonUi ui = new CommonUi();

    @Override
    public CommandResult execute(String[] args) {
        ui.showToUser("Sorry! It seems like you've entered an invalid command!");
        logger.log(Level.INFO, "Invalid command");
        return new CommandResult("", ExecutionResult.MISSING);
    }
}
