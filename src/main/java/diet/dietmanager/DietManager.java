package diet.dietmanager;

import diet.dietmanager.command.Command;

import storage.DietManagerStorage;


public class DietManager {

    private final CommandLib cl;
    private final DietManagerParser parser;
    private final DietManagerUI dietManagerUI;
    private final DietManagerStorage dietManagerStorage;

    public DietManager() {
        dietManagerStorage = new DietManagerStorage();
        dietManagerStorage.init();
        cl = new CommandLib();
        cl.initDietManagerCL();
        parser = new DietManagerParser();
        dietManagerUI = new DietManagerUI();
    }

    public void start() {
        DietManagerUI.printOpening();
        String input = dietManagerUI.getInput();
        while(!input.equals("end")) {

            try {
                processCommand(input);
            } catch (ExitException e) {
                System.out.println(e.getMessage());
                break;
            }
            input = dietManagerUI.getInput();
        }
        System.out.println("you have exited DietManager.");
    }

    public void processCommand(String input) throws ExitException {
        String[] commParts = parser.parse(input.trim());
        Command command = cl.get(commParts[0]);
        command.execute(commParts[1], dietManagerStorage);
    }
}
