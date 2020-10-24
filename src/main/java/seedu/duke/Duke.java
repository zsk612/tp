package seedu.duke;

import commands.Command;
import commands.CommandLib;
import commands.CommandResult;
import exceptions.ExceptionHandler;
import exceptions.SchwarzeneggerException;
import logger.SchwarzeneggerLogger;
import profile.Profile;
import storage.profile.ProfileStorage;
import ui.CommonUi;

import java.util.logging.Level;
import java.util.logging.Logger;

import static profile.Constants.MESSAGE_WELCOME_EXISTING_USER;
import static profile.Constants.MESSAGE_WELCOME_NEW_USER;

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
        Profile profile = null;

        try {
            profile = new ProfileStorage().loadData();
        } catch (SchwarzeneggerException e) {
            logger.log(Level.WARNING, "processing SchwarzeneggerException", e);
            ui.showToUser(ExceptionHandler.handleCheckedExceptions(e));
        } catch (Exception e) {
            logger.log(Level.WARNING, "processing uncaught exception", e);
            ui.showToUser(ExceptionHandler.handleUncheckedExceptions(e));
        }

        if (profile == null) {
            ui.showToUser(MESSAGE_WELCOME_NEW_USER);
        } else {
            ui.showToUser(String.format(MESSAGE_WELCOME_EXISTING_USER, profile.getName()));
        }
    }

    /**
     * Gets user's command and executes repeatedly until user requests to end Schwarzenegger.
     */
    private void runCommandLoopTillEnd() {
        String response = ui.getCommand("Main Menu").trim();
        String[] dummy = {};
        while (!response.equals("end")) {
            Command cm = cl.getCommand(response);
            try {
                CommandResult rs = cm.execute(dummy);
            } catch (SchwarzeneggerException e) {
                logger.log(Level.WARNING, "processing SchwarzeneggerException", e);
                ui.showToUser(ExceptionHandler.handleCheckedExceptions(e));
            } catch (Exception e) {
                logger.log(Level.WARNING, "processing uncaught exception", e);
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
