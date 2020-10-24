package diet.dietmanager;

import commands.CommandLib;
import commands.Command;
import storage.diet.DietStorage;
import ui.diet.dietmanager.DietManagerUi;


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
            } catch (ExitException e) {
                System.out.println(e.getMessage());
                break;
            }
            input = dietManagerUI.getCommand("Diet Menu");
        }
        dietManagerUI.showToUser("you have exited Diet Manager.");
    }

    /**
     * Processes the user input to interpret correct command words.
     * @param input user input for command
     * @throws ExitException handles exit exception
     */
    private void processCommand(String input) throws ExitException {
        String[] commParts = parser.parse(input.trim());
        try {
            Command command = cl.getCommand(commParts[0]);
            command.execute(commParts[1].trim(), storage);
        } catch (ArrayIndexOutOfBoundsException e) {
            dietManagerUI.showToUser("Looks like you've typed an improper command!");
        }
    }
}
