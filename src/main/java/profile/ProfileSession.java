package profile;

import commands.Command;
import commands.CommandLib;
import commands.CommandResult;
import exceptions.EndException;
import exceptions.ExceptionHandler;
import exceptions.SchwarzeneggerException;
import logger.SchwarzeneggerLogger;
import storage.profile.ProfileStorage;
import ui.CommonUi;

import java.util.logging.Level;
import java.util.logging.Logger;

import static profile.Constants.COMMAND_ARGS_INDEX;
import static profile.Constants.COMMAND_TYPE_INDEX;

/**
 * A class that is responsible for interacting with user when he/she enters Profile Session.
 */
public class ProfileSession {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();
    private CommonUi ui;
    private ProfileStorage storage;
    private ProfileParser profileParser;
    private CommandLib cl;

    /**
     * Constructs ProfileSession object.
     */
    public ProfileSession() {
        logger.log(Level.INFO, "initialising ProfileSession object");
        ui = new CommonUi();
        storage = new ProfileStorage();
        profileParser = new ProfileParser();
        cl = new CommandLib();
        cl.initProfileSessionCL();
    }

    /**
     * Runs Profile Session.
     */
    public void run() {
        start();
        runCommandLoopTillEnd();
    }

    /**
     * Starts up Profile Session with welcome message.
     */
    private void start() {
        logger.log(Level.INFO, "starting profile session");
    }

    /**
     * Gets user's command and executes repeatedly until user requests to exit Profile Session.
     */
    private void runCommandLoopTillEnd() {
        logger.log(Level.INFO, "executing profile session loop");

        while (true) {
            String userCommand = ui.getCommand("Profile Menu");
            String[] commParts = profileParser.parseCommand(userCommand);

            try {
                processCommand(commParts);
            } catch (SchwarzeneggerException e) {
                logger.log(Level.WARNING, "processing SchwarzeneggerException", e);
                ui.showToUser(ExceptionHandler.handleCheckedExceptions(e));
                
                if (e instanceof EndException) {
                    break;
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "processing uncaught exception", e);
                ui.showToUser(ExceptionHandler.handleUncheckedExceptions(e));
            }
        }
        logger.log(Level.INFO, "exiting profile session loop");
    }

    private void processCommand(String[] commParts) throws SchwarzeneggerException {
        Command command = cl.getCommand(commParts[COMMAND_TYPE_INDEX]);
        CommandResult result = command.execute(commParts[COMMAND_ARGS_INDEX], storage);
        ui.showToUser(result.getFeedbackMessage());
    }
}
