package workout.workoutmanager;

import commands.Command;
import commands.CommandLib;
import commands.CommandResult;
import exceptions.EndException;
import exceptions.SchwarzeneggerException;
import logger.SchwarzeneggerLogger;
import ui.workout.workoutmanager.WorkoutManagerUi;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WorkoutManager {

    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();
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
            } catch (EndException e) {
                logger.log(Level.INFO, "exiting workout manager");
                ui.showToUser(e.getMessage());
                break;
            } catch (SchwarzeneggerException e) {
                logger.log(Level.WARNING, "processing SchwarzeneggerException", e);
                ui.showToUser(e.getMessage());
            }
        }
    }

    private void processCommand(String[] commands) throws SchwarzeneggerException {
        Command command = cl.get(commands[0]);
        CommandResult result = command.execute(Arrays.copyOfRange(commands, 1, commands.length));
        ui.showToUser(result.getFeedbackMessage());
    }
}
