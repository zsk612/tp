package workout.workoutmanager;

import commands.Command;
import commands.CommandLib;
import commands.ExecutionResult;
import storage.workout.WorkOutManagerStorage;
import ui.workout.workoutmanager.WorkoutManagerUi;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;


public class WorkoutManager {

    private final CommandLib cl;

    public WorkoutManager() {
        WorkOutManagerStorage.init();
        cl = new CommandLib();
        cl.initWorkoutManagerCL();
        logger.log(Level.INFO, "initialised workout manager command library");
    }

    public void start() {
        logger.log(Level.INFO, "entered workout manager");
        WorkoutManagerUi.printOpening();
        while (true) {

            String command = getCommand();
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
        Command command = cl.get(commands[0]);
        ExecutionResult result = command.execute(Arrays.copyOfRange(commands, 1, commands.length));
        if (result == ExecutionResult.OK) {
            command.printResponse();
        }
    }

    private static String getCommand() {
        System.out.print(">>>>> ");
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();

        // Silently consume all blank lines
        while (inputLine.trim().isEmpty()) {
            System.out.print(">>>>> ");
            inputLine = sc.nextLine();
        }

        return inputLine;
    }
}
