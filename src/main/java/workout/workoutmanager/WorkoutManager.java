package workout.workoutmanager;

import storage.workout.WorkOutManagerStorage;
import ui.workout.workoutmanager.WorkoutManagerUi;
import workout.workoutmanager.command.Command;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkoutManager {

    private static final Logger logger = Logger.getLogger("java.workout.workoutmanager");
    private final CommandLib cl;

    public WorkoutManager() {
        WorkOutManagerStorage.init();
        logger.log(Level.INFO, "initialisd workout manager");
        cl = new CommandLib();
        cl.initWorkoutManagerCL();
        logger.log(Level.INFO, "initialisd workout manager command library");
    }

    public void start() {
        logger.log(Level.INFO, "entered workout manager");
        WorkoutManagerUi.printOpening();
        Scanner sc = new Scanner(System.in);
        while (true) {

            String command = sc.nextLine();
            logger.log(Level.FINE, "received input" + command);
            WorkoutManagerUi.printSeperationLine();
            String[] commParts = WorkoutManagerParser.parse(command);

            try {
                processCommand(commParts);
            } catch (ExitException e) {
                logger.log(Level.INFO, "exiting workout manager");
                break;
            }
            WorkoutManagerUi.printSeperationLine();
        }
    }

    private void processCommand(String[] commands) throws ExitException {
        try {
            Command command = cl.get(commands[0]);
            command.execute(Arrays.copyOfRange(commands, 1, commands.length));
        } catch (NullPointerException e) {
            logger.log(Level.WARNING, "command not recognised");
            WorkoutManagerUi.commandNotFoundResponse();
        }
    }
}
