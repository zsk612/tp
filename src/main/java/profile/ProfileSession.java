package profile;

import commands.Command;
import commands.CommandResult;
import commands.profile.EndProfile;
import exceptions.ExceptionHandler;
import exceptions.SchwarzeneggerException;
import logger.SchwarzeneggerLogger;
import storage.profile.ProfileStorage;
import ui.CommonUi;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class that is responsible for interacting with user when he/she enters Profile Session.
 */
public class ProfileSession {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();
    private CommonUi ui;
    private ProfileStorage storage;
    private ProfileParser profileParser;
    private ExceptionHandler exceptionHandler;

    /**
     * Constructs ProfileManager object.
     */
    public ProfileSession() {
        logger.log(Level.INFO, "initialising ProfileSession object");
        ui = new CommonUi();
        storage = new ProfileStorage();
        profileParser = new ProfileParser();
        exceptionHandler = new ExceptionHandler();
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
        Command command = null;

        logger.log(Level.INFO, "executing profile session loop");
        do {
            try {
                String userCommand = ui.getCommand("Profile Menu");
                command = profileParser.parseCommand(userCommand);
                CommandResult result = command.execute(storage);
                ui.showToUser(result.toString());
            } catch (SchwarzeneggerException e) {
                logger.log(Level.WARNING, "processing SchwarzeneggerException", e);
                ui.showToUser(exceptionHandler.handleCheckedExceptions(e));
            } catch (Exception e) {
                logger.log(Level.WARNING, "processing uncaught exception", e);
                ui.showToUser(exceptionHandler.handleUncheckedExceptions(e));
            }
        } while (!EndProfile.isEnd(command));

        logger.log(Level.INFO, "exiting profile session loop");
    }
}
