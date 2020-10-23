package commands.main;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import ui.CommonUi;
import ui.diet.dietsession.DietSessionUi;

import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class Wrong extends Command {

    CommonUi ui = new CommonUi();
    @Override
    public CommandResult execute(String[] args) {
        ui.showToUser("Sorry! It seems like you've entered an invalid command!");
        logger.log(Level.INFO, "Invalid command");
        return new CommandResult("", ExecutionResult.MISSING);
    }
}
