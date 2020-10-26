package seedu.duke;

import commands.Command;
import commands.CommandLib;
import commands.CommandResult;
import exceptions.ExceptionHandler;
import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidSaveFormatException;
import logger.SchwarzeneggerLogger;
import models.Profile;
import storage.profile.ProfileStorage;
import ui.CommonUi;

import java.util.logging.Logger;

import static profile.Constants.MESSAGE_WELCOME_EXISTING_USER;
import static profile.Constants.MESSAGE_WELCOME_NEW_USER;
import static profile.Constants.MESSAGE_WELCOME_WITH_INVALID_SAVE_FORMAT;
import static seedu.duke.Constant.COMMAND_WORD_END;

/**
 * The Schwarzenegger program implements an application that keeps track of the user's gym and diet record.
 */
public class Duke {
    private CommandLib cl;
    private CommonUi ui;
    private Logger logger;

    private Duke() {
        cl = new CommandLib();
        cl.initMainMenu();
        ui = new CommonUi();
        logger = SchwarzeneggerLogger.getInstanceLogger();
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

        String response = ui.getCommand("Main Menu").trim();
        String[] dummy = {};

        while (!response.equals(COMMAND_WORD_END)) {
            Command cm = cl.getCommand(response);

            try {
                CommandResult rs = cm.execute(dummy);
            } catch (SchwarzeneggerException e) {
                ui.showToUser(ExceptionHandler.handleCheckedExceptions(e));
            } catch (Exception e) {
                ui.showToUser(ExceptionHandler.handleUncheckedExceptions(e));
            }
            response = ui.getCommand("Main Menu").trim();
        }
    }

    /**
     * Ends Schwarzenegger.
     */
    private void end() {
        ui.showToUser("Bye, you have exited the Schwarzenegger.");
        System.exit(0);
    }
}
