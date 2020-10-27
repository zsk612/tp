package diet.dietmanager;

import commands.Command;
import commands.CommandLib;
import diet.dietsession.DietSession;
import exceptions.ExceptionHandler;
import exceptions.InvalidCommandWordException;
import exceptions.InvalidDateFormatException;
import exceptions.diet.InvalidSearchDateException;
import exceptions.profile.InvalidCommandFormatException;
import logger.SchwarzeneggerLogger;
import storage.diet.DietStorage;
import ui.diet.dietmanager.DietManagerUi;

import java.io.File;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DietManager {

    private final CommandLib cl;
    private final DietManagerParser parser;
    private final DietManagerUi dietManagerUI;
    private final DietStorage storage;

    /**
     * Constructs DietManager and initialize command library for dietManager.
     */
    public DietManager() {
        storage = new DietStorage();
        cl = new CommandLib();
        cl.initDietManagerCL();
        parser = new DietManagerParser();
        dietManagerUI = new DietManagerUi();
    }

    /**
     * Starts diet manager to read user input.
     */
    public void start() {
        DietManagerUi.printOpening();
        String input = dietManagerUI.getCommand("Diet Menu");
        assert input != null : "Null input before input loop";
        while (!input.equals("end")) {
            try {
                processCommand(input);
            } catch (InvalidCommandWordException e) {
                dietManagerUI.showToUser(ExceptionHandler.handleCheckedExceptions(e));
            }
            input = dietManagerUI.getCommand("Diet Menu");
        }
        DietManagerUi.printBye();
    }

    /**
     * Processes the user input to interpret correct command words.
     *
     * @param input user input for command.
     * @throws InvalidCommandWordException handles InvalidCommandWordException.
     */
    private void processCommand(String input) throws InvalidCommandWordException {
        String[] commParts = parser.parse(input.trim());
        try {
            Command command = cl.getCommand(commParts[0]);
            command.execute(commParts[1].trim(), storage);
        } catch (ArrayIndexOutOfBoundsException | InvalidCommandFormatException e) {
            throw new InvalidCommandWordException();
        } catch (InvalidDateFormatException e) {
            dietManagerUI.showToUser("wrong format for date input.");
        } catch (InvalidSearchDateException e) {
            dietManagerUI.showToUser("Starting date should be earlier than end date.");
        }
    }

    public double getTodayTotalCalories() {
        Logger logger = SchwarzeneggerLogger.getInstanceLogger();
        double todayTotalCalories = 0;
        File folder = new File("saves/diet/");
        File[] listOfFiles = folder.listFiles();
        StringBuilder listResult = new StringBuilder();
        assert folder.exists();
        try {
            if (Objects.requireNonNull(listOfFiles).length == 0) {
                listResult.append("It seems like you have not eaten anything today!");
            }

            for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++) {
                DietSession ds = storage.readDietSession(listOfFiles[i].getName());
                if (ds.getDate().equals(java.time.LocalDate.now())) {
                    todayTotalCalories += ds.getTotalCalories();
                }
            }
            logger.log(Level.INFO, "Calculated total calories so far today");
        } catch (NullPointerException e) {
            logger.log(Level.WARNING, "No instances of diet sessions saved");
        }
        return todayTotalCalories;
    }
}
