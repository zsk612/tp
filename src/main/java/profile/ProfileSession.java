package profile;

import commands.profile.AddProfile;
import commands.profile.Command;
import commands.profile.CommandResult;
import commands.profile.EndProfile;
import exceptions.ExceptionHandler;
import exceptions.SchwarzeneggerException;
import profile.parser.ProfileParser;
import storage.profile.Storage;
import ui.profile.ProfileUi;

import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

/**
 * A class that is responsible for interacting with user when he/she enters Profile Session.
 */
public class ProfileSession {
    public boolean hasExit;
    private ProfileUi profileUi;
    private Storage storage;
    private ProfileParser profileParser;
    private Profile profile;
    private ExceptionHandler exceptionHandler;

    /**
     * Constructs ProfileManager object.
     */
    public ProfileSession() {
        try {
            logger.log(Level.INFO, "initialising ProfileSession object");
            hasExit = false;
            profileUi = new ProfileUi();
            storage = new Storage();
            profileParser = new ProfileParser();
            exceptionHandler = new ExceptionHandler();
            profile = storage.loadData(profileUi);

            if (!storage.getHasExistingProfile()) {
                logger.log(Level.INFO, "getting first time configuration for user profile");
                profile = profileUi.getProfileConfig();
                storage.saveData(profile);
            }
        } catch (SchwarzeneggerException e) {
            logger.log(Level.WARNING, "processing SchwarzeneggerException", e);
            profileUi.showToUser(e.getMessage());
        } catch (Exception e) {
            logger.log(Level.WARNING, "processing uncaught exception", e);
            profileUi.showToUser(e.toString());
        }
    }

    /**
     * Runs Profile Session.
     */
    public void run() {
        start();
        runCommandLoop();
        exit();
    }

    /**
     * Starts up Profile Session with welcome message.
     */
    private void start() {
        logger.log(Level.INFO, "starting profile session");
        profileUi.greetUser(profile.getName());
    }

    /**
     * Gets user's command and executes repeatedly until user requests to exit Profile Session.
     */
    private void runCommandLoop() {
        Command command = null;

        logger.log(Level.INFO, "executing profile session loop");
        do {
            try {
                String userCommand = profileUi.getCommand();
                command = profileParser.parseCommand(userCommand);
                CommandResult result = command.execute(profile, storage);
                profileUi.showToUser(result.toString());

                if (profile.isDeleted && AddProfile.isAddCommand(command)) {
                    profile = profileUi.getProfileConfig();
                    storage.saveData(profile);
                }
            } catch (SchwarzeneggerException e) {
                logger.log(Level.WARNING, "processing SchwarzeneggerException", e);
                profileUi.showToUser(exceptionHandler.handleCheckedExceptions(e));
            } catch (Exception e) {
                logger.log(Level.WARNING, "processing uncaught exception", e);
                profileUi.showToUser(exceptionHandler.handleUncheckedExceptions(e));
            }
        } while (!EndProfile.isExit(command));

        logger.log(Level.INFO, "exiting profile session loop");
    }

    /**
     * Sets hasExit to true to indicate user has requested to exit ProfileSession.
     */
    private void exit() {
        logger.log(Level.INFO, "exiting profile session");
        hasExit = true;
    }
}
