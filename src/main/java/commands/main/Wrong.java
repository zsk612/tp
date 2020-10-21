package commands.main;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;

import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class Wrong extends Command {

    @Override
    public CommandResult execute(String[] args) {
        System.out.println("Sorry! It seems like you've entered an invalid command!");
        logger.log(Level.INFO, "Invalid command");
        return new CommandResult("", ExecutionResult.MISSING);
    }
}
