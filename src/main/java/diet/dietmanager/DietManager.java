package diet.dietmanager;

import diet.dietmanager.command.Command;
import diet.dietmanager.command.DietSessionList;
import diet.dietmanager.command.NewDietSession;
import diet.dietsession.DietSession;
import storage.DietManagerStorage;

import java.util.Arrays;
import java.util.Scanner;

public class DietManager {

    private final CommandLib cl;

    private final DietManagerUI dietManagerUI;

    public DietManager() {
        DietManagerStorage.init();
        cl = new CommandLib();
        cl.initDietManagerCL();
        dietManagerUI = new DietManagerUI();
    }

    public void start() {
        DietManagerUI.printOpening();
        String input = dietManagerUI.getInput();
        while(!input.equals("end")) {

            String[] commParts = DietManagerParser.parse(input);

            try {
                processCommand(commParts);
            } catch (ExitException e) {
                System.out.println(e.getMessage());
                break;
            }
            input = dietManagerUI.getInput();
        }
        System.out.println("you have exited DietManager.");
    }

    public void processCommand(String[] commands) throws ExitException {
        Command command = cl.get(commands[0]);
        command.execute();
    }
}
