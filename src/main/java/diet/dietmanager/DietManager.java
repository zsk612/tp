package diet.dietmanager;

import commands.CommandLib;
import commands.Command;
import storage.diet.Storage;
import ui.diet.dietmanager.DietManagerUi;


public class DietManager {

    private final CommandLib cl;
    private final DietManagerParser parser;
    private final DietManagerUi dietManagerUI;
    private final Storage storage;

    public DietManager() {
        storage = new Storage();
        cl = new CommandLib();
        cl.initDietManagerCL();
        parser = new DietManagerParser();
        dietManagerUI = new DietManagerUi();
    }

    public void start() {
        DietManagerUi.printOpening();
        String input = dietManagerUI.getInput();
        assert input != null : "Null input before input loop";
        while (!input.equals("end")) {
            try {
                processCommand(input);
            } catch (ExitException e) {
                System.out.println(e.getMessage());
                break;
            }
            input = dietManagerUI.getInput();
        }
        System.out.println("you have exited Diet Manager.");
    }

    private void processCommand(String input) throws ExitException {
        String[] commParts = parser.parse(input.trim());
        try {
            Command command = cl.get(commParts[0]);
            command.execute(commParts[1], storage);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Looks like you've typed an improper command!");
        }
    }
}
