package workout.workoutmanager;

import commands.Command;
import commands.CommandLib;
import commands.CommandResult;
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
        logger.log(Level.INFO, "Initialised workout manager command library");
        ui = new WorkoutManagerUi();
    }

    /**
     * Start a workout manager. Goes into a REPL until 'end' command is given.
     */
    public void start() {
        logger.log(Level.INFO, "Entered workout manager");
        WorkoutManagerUi.printOpening();
        while (true) {

            String command = ui.getCommand("Workout Manager");
            logger.log(Level.INFO, "received input" + command);

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
            logger.log(Level.INFO, command + " is executed with " + result.getStatus() + " status");
            ui.showToUser(result.getFeedbackMessage());
        } catch (SchwarzeneggerException e) {
            logger.log(Level.WARNING, "Processing SchwarzeneggerException", e);
            ui.showToUser(e.getMessage());
        }
    }
}
