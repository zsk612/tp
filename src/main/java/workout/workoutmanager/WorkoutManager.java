package workout.workoutmanager;

import commands.Command;
import commands.CommandLib;
import commands.CommandResult;
import commands.ExecutionResult;
import exceptions.SchwarzeneggerException;
import logger.SchwarzeneggerLogger;
import storage.workout.WorkOutManagerStorage;
import ui.workout.workoutmanager.WorkoutManagerUi;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;


public class WorkoutManager {

    private final CommandLib cl;
    private final WorkoutManagerUi ui;

    public WorkoutManager() {
        cl = new CommandLib();
        cl.initWorkoutManagerCL();
        logger.log(Level.INFO, "initialised workout manager command library");
        ui = new WorkoutManagerUi();
    }

    public void start() {
        logger.log(Level.INFO, "entered workout manager");
        WorkoutManagerUi.printOpening();
        while (true) {

            String command = ui.getCommand("Workout Manager");
            logger.log(Level.FINE, "received input" + command);

            String[] commParts = WorkoutManagerParser.parse(command);
            try {
                processCommand(commParts);
            } catch (ExitException e) {
                logger.log(Level.INFO, "exiting workout manager");
                break;
            }
        }
    }

    private void processCommand(String[] commands) throws ExitException {
        Command command = cl.get(commands[0]);
        try {
            CommandResult result = command.execute(Arrays.copyOfRange(commands, 1, commands.length));
            ui.showToUser(result.getFeedbackMessage());
        } catch (SchwarzeneggerException e) {
            logger.log(Level.WARNING, "processing SchwarzeneggerException", e);
            ui.showToUser(e.getMessage());
        }
    }
}
