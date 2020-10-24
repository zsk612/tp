package commands.profile;

import commands.Command;
import commands.CommandResult;
import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidCommandWordException;
import logger.SchwarzeneggerLogger;
import storage.profile.ProfileStorage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfileWrong extends Command {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();

    @Override
    public CommandResult execute(String commandArgs, ProfileStorage storage) throws SchwarzeneggerException {
        logger.log(Level.WARNING, "command not recognised");
        throw new InvalidCommandWordException();
    }
}
