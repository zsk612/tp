package seedu.duke;

import logic.commands.Command;
import logic.commands.CommandLib;
import logic.commands.CommandResult;
import exceptions.EndException;
import exceptions.ExceptionHandler;
import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidSaveFormatException;
import logger.SchwarzeneggerLogger;
import logic.parser.CommonParser;
import models.Profile;
import storage.profile.ProfileStorage;
import ui.CommonUi;

import java.util.logging.Logger;

import static profile.Constants.COMMAND_ARGS_INDEX;
import static profile.Constants.COMMAND_TYPE_INDEX;
import static ui.profile.ProfileUi.MESSAGE_WELCOME_EXISTING_USER;
import static ui.profile.ProfileUi.MESSAGE_WELCOME_NEW_USER;
import static ui.profile.ProfileUi.MESSAGE_WELCOME_WITH_INVALID_SAVE_FORMAT;

/**
 * The Schwarzenegger program implements an application that keeps track of the user's gym and diet record.
 */
public class Duke {
    private static Logger logger;
    private CommandLib cl;
    private CommonUi ui;
    private CommonParser parser;

    private Duke() {
        logger = SchwarzeneggerLogger.getInstanceLogger();
        cl = new CommandLib();
        cl.initMainMenu();
        ui = new CommonUi();
        parser = new CommonParser();
    }

    /**
     * Main entry-point for the java.seedu.duke.Duke application.
     *
     * @param args Unused in Schwarzenegger.
     */
    public static void main(String[] args) {
        new Duke().run();
    }

    /**
     * Runs Schwarzenegger.
     */
    private void run() {
        start();
        runCommandLoopTillEnd();
        end();
    }

    /**
     * Starts up Duke with greeting message.
     */
    private void start() {
        Profile profile;

        try {
            profile = new ProfileStorage().loadData();
            ui.showToUser(String.format(MESSAGE_WELCOME_EXISTING_USER, profile.getName()));
        } catch (SchwarzeneggerException e) {
            if (e instanceof InvalidSaveFormatException) {
                ui.showToUser(MESSAGE_WELCOME_WITH_INVALID_SAVE_FORMAT);
            } else {
                ui.showToUser(ExceptionHandler.handleCheckedExceptions(e));
                ui.showToUser(MESSAGE_WELCOME_NEW_USER);
            }
        } catch (Exception e) {
            if (!(e instanceof NullPointerException)) {
                ui.showToUser(ExceptionHandler.handleUncheckedExceptions(e));
            }
            ui.showToUser(MESSAGE_WELCOME_NEW_USER);
        }
    }

    /**
     * Gets user's command and executes repeatedly until user requests to end Schwarzenegger.
     */
    private void runCommandLoopTillEnd() {
        logger.info("running main menu loop");

        while (true) {
            String userInput = ui.getCommand("Main Menu");
            String[] commParts = parser.parseCommand(userInput);
            Command cm = cl.getCommand(commParts[COMMAND_TYPE_INDEX]);

            try {
                CommandResult rs = cm.execute(commParts[COMMAND_ARGS_INDEX]);
            } catch (SchwarzeneggerException e) {
                if (e instanceof EndException) {
                    break;
                }

                ui.showToUser(ExceptionHandler.handleCheckedExceptions(e));
            } catch (Exception e) {
                ui.showToUser(ExceptionHandler.handleUncheckedExceptions(e));
            }
        }
    }

    /**
     * Ends Schwarzenegger.
     */
    private void end() {
        ui.showToUser("Bye, you have exited The Schwarzenegger.");
        System.exit(0);
    }
}
