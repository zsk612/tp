package workout.workoutmanager;

import logic.commands.Command;
import logic.commands.CommandLib;
import logic.commands.CommandResult;
import exceptions.EndException;
import exceptions.SchwarzeneggerException;
import logger.SchwarzeneggerLogger;
import ui.workout.workoutmanager.WorkoutManagerUi;

import java.util.logging.Level;
import java.util.logging.Logger;


public class WorkoutManager {

    private static final Logger logger = SchwarzeneggerLogger.getInstanceLogger();
    private final CommandLib cl;
    private final WorkoutManagerUi ui;

    public WorkoutManager() {
        cl = new CommandLib();
        cl.initWorkoutManagerCL();
        logger.log(Level.INFO, "Initialised workout manager command library");
        ui = new WorkoutManagerUi();
    }

    /**
     * Starts a workout manager. Goes into a REPL until 'end' command is given.
     */
    public void start() {
        logger.log(Level.INFO, "Entered workout manager");
        ui.printOpening("Workout Menu");

        while (true) {

            String command = ui.getCommand("Workout Menu");
            logger.log(Level.INFO, "Received input" + command);

            String[] commParts = WorkoutManagerParser.parseCommandKw(command);
            try {
                processCommand(commParts);
            } catch (EndException e) {
                logger.log(Level.INFO, "exiting workout manager");
                break;
            } catch (SchwarzeneggerException e) {
                logger.log(Level.WARNING, "processing SchwarzeneggerException", e);
                ui.showToUser(e.getMessage());
            }
        }

        ui.printReturning("Main Menu");
    }

    private void processCommand(String[] commands) throws SchwarzeneggerException {
        Command command = cl.getCommand(commands[0]);
        CommandResult result = command.execute((commands.length > 1) ? commands[1].trim() : "");
        ui.showToUser(result.getFeedbackMessage());
    }
}
