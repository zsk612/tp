package profile;

import logic.commands.Command;
import logic.commands.CommandLib;
import logic.commands.CommandResult;
import exceptions.EndException;
import exceptions.ExceptionHandler;
import exceptions.SchwarzeneggerException;
import logger.SchwarzeneggerLogger;
import logic.parser.CommonParser;
import storage.profile.ProfileStorage;
import ui.CommonUi;

import java.util.logging.Level;
import java.util.logging.Logger;

import static profile.Constants.COMMAND_ARGS_INDEX;
import static profile.Constants.COMMAND_TYPE_INDEX;

/**
 * A class that is responsible for interacting with user in Profile Session.
 */
public class ProfileSession {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();
    private CommonUi ui;
    private CommonParser parser;
    private ProfileStorage storage;
    private CommandLib cl;

    /**
     * Constructs ProfileSession object.
     */
    public ProfileSession() {
        logger.log(Level.INFO, "initialising ProfileSession object");
        ui = new CommonUi();
        storage = new ProfileStorage();
        parser = new CommonParser();
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
        ui.printOpening("Profile Menu");
    }

    /**
     * Gets user's command and executes repeatedly until user requests to exit Profile Session.
     */
    private void runCommandLoopTillEnd() {
        logger.log(Level.INFO, "executing profile session loop");

        while (true) {
            String userCommand = ui.getCommand("Profile Menu");
            assert userCommand != null : "input should not be null before process loop";

            String[] commParts = parser.parseCommand(userCommand);
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

    /**
     * Processes and displays parsed user input.
     *
     * @param commParts Size 2 array; first element is the command type and second element is the arguments
     *         string.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    private void processCommand(String[] commParts) throws SchwarzeneggerException {
        Command command = cl.getCommand(commParts[COMMAND_TYPE_INDEX]);
        assert command != null : "command object should not be null null";

        CommandResult result = command.execute(commParts[COMMAND_ARGS_INDEX], storage);
        assert result != null : "command result object should not be null null";

        ui.showToUser(result.getFeedbackMessage());
    }
}
