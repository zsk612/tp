package diet.dietsession;

import commands.Command;
import commands.CommandLib;
import logger.SchwarzeneggerLogger;
import storage.diet.DietStorage;
import ui.diet.dietsession.DietSessionUi;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DietSession {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();
    private final ArrayList<Food> foodList;

    private final String dateInput;
    private final String typeInput;
    private final LocalDate date;

    private final DietSessionUi dietSessionUI;
    private transient CommandLib cl;
    private final DietStorage storage;
    private final DietSessionParser parser = new DietSessionParser();
    public boolean endDietSession = false;

    /**
     * Constructs DietSession and initialize command library for dietSession.
     */
    public DietSession(String typeInput, String dateInput) {
        this.cl = new CommandLib();
        cl.initDietSessionCL();
        this.dateInput = dateInput;
        this.date = parser.parseDate(dateInput);
        this.typeInput = typeInput;
        this.foodList = new ArrayList<>();
        storage = new DietStorage();
        dietSessionUI = new DietSessionUi();
    }

    public String getDateInput() {
        return dateInput;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getTypeInput() {
        return typeInput;
    }

    public void setEndDietSession(Boolean hasEnded) {
        this.endDietSession = hasEnded;
    }

    /**
     * Starts dietSession and initializes command library for dietSession.
     *
     * @throws IOException handles input/output exception
     */
    public void start() throws IOException {

        logger.log(Level.INFO, "starting diet session");
        this.cl = new CommandLib();
        cl.initDietSessionCL();
        dietSessionUI.printOpening();
        setEndDietSession(false);
        String input = dietSessionUI.getCommand("Diet Menu > Diet Session");
        dietSessionInputLoop(input);
        setEndDietSession(true);
        dietSessionUI.printExit();
    }

    /**
     * Starts reading user input for dietSession commands.
     *
     * @param input user input for command
     */
    private void dietSessionInputLoop(String input) {
        while (!input.equals("end")) {

            try {
                processCommand(input);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                break;
            }
            input = dietSessionUI.getCommand("Diet Menu > Diet Session");
        }
    }

    /**
     * Processes user input for dietSession commands.
     *
     * @param input user input for command
     * @throws NullPointerException handles null pointer exception
     */
    private void processCommand(String input) throws NullPointerException {
        String[] commParts = parser.parse(input);
        Command command = cl.getCommand(commParts[0]);
        command.execute(commParts[1].trim(), foodList, storage);
    }
}
