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
     * Starts up Profile Session.
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
            assert userCommand != null : "input should not be null before process loop";

            String[] commParts = profileParser.parseCommand(userCommand);
            assert commParts != null : "parsed array should not be null before process loop";

            try {
                processCommand(commParts);
            } catch (SchwarzeneggerException e) {
                ui.showToUser(ExceptionHandler.handleCheckedExceptions(e));

                if (e instanceof EndException) {
                    break;
                }
            } catch (Exception e) {
                ui.showToUser(ExceptionHandler.handleUncheckedExceptions(e));
            }
        }
        logger.log(Level.INFO, "exiting profile session loop");
    }

    private void processCommand(String[] commParts) throws SchwarzeneggerException {
        Command command = cl.getCommand(commParts[COMMAND_TYPE_INDEX]);
        assert command != null : "command object should not be null null";

        CommandResult result = command.execute(commParts[COMMAND_ARGS_INDEX], storage);
        assert result != null : "command result object should not be null null";

        ui.showToUser(result.getFeedbackMessage());
    }
}
