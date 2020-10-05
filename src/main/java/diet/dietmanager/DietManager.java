package diet.dietmanager;

import diet.dietmanager.command.Command;
import storage.DietManagerStorage;

import java.util.Arrays;
import java.util.Scanner;

public class DietManager {

    private final CommandLib cl;

    public DietManager() {
        DietManagerStorage.init();
        cl = new CommandLib();
        cl.initDietManagerCL();
    }

    public void start() {
        DietManagerUI.printOpening();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String command = sc.nextLine();
            String[] commParts = DietManagerParser.parse(command);

            try {
                processCommand(commParts);
            } catch (ExitException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    public void processCommand(String[] commands) throws ExitException {
        Command command = cl.get(commands[0]);
        command.execute(Arrays.copyOfRange(commands, 1, commands.length));
    }
}
