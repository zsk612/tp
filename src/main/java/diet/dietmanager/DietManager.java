package diet.dietmanager;

import java.util.Arrays;
import java.util.Scanner;

public class DietManager {

    private final CommandLib cl;

    public DietManager() {
        cl = new CommandLib();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String command = sc.nextLine();
            //String[] commParts = WorkoutManagerParser.parse(command);

            try {
                processCommand(commParts);
            } catch (ExitException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    public void processCommand(String[] commands) throws ExitException {
        //Command command = cl.get(commands[0]);
        command.execute(Arrays.copyOfRange(commands, 1, commands.length));
    }
}
