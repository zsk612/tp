package profile;

import profile.commands.AddCommand;
import profile.commands.Command;
import profile.commands.CommandResult;
import profile.commands.ExitCommand;
import profile.components.ExceptionHandler;
import profile.components.Profile;
import profile.exceptions.SchwarzeneggerException;
import profile.parser.ProfileParser;
import profile.storage.Storage;
import profile.ui.ProfileUi;

/**
 * A class that is responsible for interacting with user when he/she enters Profile Session.
 */
public class ProfileManager {
    public boolean hasExit;
    private ProfileUi profileUi;
    private Storage storage;
    private ProfileParser profileParser;
    private Profile profile;
    private ExceptionHandler exceptionHandler;

    /**
     * Constructs ProfileManager object.
     */
    public ProfileManager() {
        try {
            hasExit = false;
            profileUi = new ProfileUi();
            storage = new Storage();
            profileParser = new ProfileParser();
            exceptionHandler = new ExceptionHandler();
            profile = storage.loadData(profileUi);

            if (!storage.getHasExistingProfile()) {
                profile = profileUi.getProfileConfig();
                storage.saveData(profile);
            }
        } catch (SchwarzeneggerException e) {
            profileUi.showToUser(e.getMessage());
        } catch (Exception e) {
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
        profileUi.greetUser(profile.getName());
    }

    /**
     * Gets user's command and executes repeatedly until user requests to exit Profile Session.
     */
    private void runCommandLoop() {
        Command command = null;

        do {
            try {
                String userCommand = profileUi.getCommand();
                command = profileParser.parseCommand(userCommand);
                CommandResult result = command.execute(profile, storage);
                profileUi.showToUser(result.toString());

                if (profile.isDeleted && AddCommand.isAddCommand(command)) {
                    profile = profileUi.getProfileConfig();
                    storage.saveData(profile);
                }
            } catch (SchwarzeneggerException e) {
                profileUi.showToUser(exceptionHandler.handleCheckedExceptions(e));
            } catch (Exception e) {
                profileUi.showToUser(exceptionHandler.handleUncheckedExceptions(e));
            }
        } while (!ExitCommand.isExit(command));
    }

    /**
     * Sets hasExit to true to indicate user has requested to exit ProfileSession.
     */
    private void exit() {
        hasExit = true;
    }
}
