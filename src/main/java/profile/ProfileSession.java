package profile;

import commands.Command;
import commands.CommandResult;
import commands.profile.AddProfile;
import commands.profile.EndProfile;
import exceptions.ExceptionHandler;
import exceptions.SchwarzeneggerException;
import storage.profile.Storage;
import ui.profile.ProfileUi;

import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;
import static profile.Constants.SCANNER;

/**
 * A class that is responsible for interacting with user when he/she enters Profile Session.
 */
public class ProfileSession {
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
            profileUi = new ProfileUi();
            storage = new Storage();
            profileParser = new ProfileParser();
            exceptionHandler = new ExceptionHandler();
            profile = storage.loadData(profileUi);

            if (profile == null) {
                profile = initProfile();
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
        runCommandLoopTillEnd();
    }

    /**
     * Starts up Profile Session with welcome message.
     */
    private void start() {
        logger.log(Level.INFO, "starting profile session");
        profileUi.greetUser(profile.getName());
    }

    private Profile initProfile() {
        Profile profile = null;

        while (profile == null) {
            try {
                while (profile == null) {
                    logger.log(Level.INFO, "no existing profile in database");
                    System.out.print(">>>> ");
                    String input = SCANNER.nextLine();
                    Command command = new AddProfile(input);
                    profile = command.execute(profile);
                    CommandResult result = command.getExecutionResult(profile);
                    storage.saveData(profile);
                    profileUi.showToUser(result.toString());
                }
            } catch (SchwarzeneggerException e) {
                logger.log(Level.WARNING, "processing SchwarzeneggerException", e);
                profileUi.showToUser(e.getMessage());
            } catch (Exception e) {
                logger.log(Level.WARNING, "processing uncaught exception", e);
                profileUi.showToUser(e.toString());
            }
        }

        return profile;
    }

    /**
     * Gets user's command and executes repeatedly until user requests to exit Profile Session.
     */
    private void runCommandLoopTillEnd() {
        Command command = null;

        logger.log(Level.INFO, "executing profile session loop");
        do {
            try {
                String userCommand = profileUi.getCommand();
                command = profileParser.parseCommand(userCommand);
                profile = command.execute(profile);
                CommandResult result = command.getExecutionResult(profile);
                storage.saveData(profile);
                profileUi.showToUser(result.toString());

            } catch (SchwarzeneggerException e) {
                logger.log(Level.WARNING, "processing SchwarzeneggerException", e);
                profileUi.showToUser(exceptionHandler.handleCheckedExceptions(e));
            } catch (Exception e) {
                logger.log(Level.WARNING, "processing uncaught exception", e);
                profileUi.showToUser(exceptionHandler.handleUncheckedExceptions(e));
            }
        } while (!EndProfile.isEnd(command));

        logger.log(Level.INFO, "exiting profile session loop");
    }
}
