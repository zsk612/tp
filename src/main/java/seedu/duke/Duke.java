package seedu.duke;

import commands.Command;
import commands.CommandLib;
import commands.CommandResult;
import exceptions.ExceptionHandler;
import exceptions.SchwarzeneggerException;
import logger.SchwarzeneggerLogger;
import ui.CommonUi;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Schwarzenegger program implements an application that keeps track of the user's gym and diet record.
 */
public class Duke {
    private CommandLib cl;
    private CommonUi ui;
    private ExceptionHandler exceptionHandler;
    private Logger logger;

    public Duke() {
        cl = new CommandLib();
        cl.initMainMenu();
        ui = new CommonUi();
        exceptionHandler = new ExceptionHandler();
        logger = SchwarzeneggerLogger.getInstanceLogger();
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     *
     * @param args Unused in Duke.
     */

    public static void main(String[] args) {
        new Duke().run();
    }

    /**
     * Runs Schwarzenegger.
     */
    private void run() {
        System.out.println("Greetings from Schwarzenegger!");
        String response = ui.getCommand("Main menu").trim();
        String[] dummy = {};
        while (!response.equals("end")) {
            Command cm = cl.get(response);
            try {
                CommandResult rs = cm.execute(dummy);
            } catch (SchwarzeneggerException e) {
                logger.log(Level.WARNING, "processing SchwarzeneggerException", e);
                ui.showToUser(exceptionHandler.handleCheckedExceptions(e));
            }
            response = ui.getCommand("Main menu").trim();
        }
        System.out.println("Bye, you have exited the Schwarzenegger.");
    }
}