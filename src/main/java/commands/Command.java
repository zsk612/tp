package commands;

import diet.dietsession.Food;
import exceptions.InvalidCommandWordException;
import exceptions.InvalidDateFormatException;
import exceptions.SchwarzeneggerException;
import exceptions.diet.InvalidSearchDateException;
import exceptions.profile.InvalidCommandFormatException;
import logger.SchwarzeneggerLogger;
import storage.diet.DietStorage;
import storage.profile.ProfileStorage;
import ui.CommonUi;
import workout.workoutsession.exercise.ExerciseList;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Command {

    public Logger logger = SchwarzeneggerLogger.getInstanceLogger();
    public static CommonUi ui = new CommonUi();

    /**
     * Executes the command with given arguments.
     *
     * @param args Array of user's input.
     * @return An object CommandResult containing the executing status and feedback message to be displayed
     *         to user.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    public CommandResult execute(String args) throws SchwarzeneggerException {
        logger.log(Level.INFO, "Executing " + this);
        return new CommandResult();
    }

    /**
     * Executes the command with user's input.
     *
     * @param commandArgs User's input arguments.
     * @param storage Profile Storage to load and save data.
     * @return Result of command execution.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    public CommandResult execute(String commandArgs, ProfileStorage storage) throws SchwarzeneggerException {
        logger.log(Level.INFO, "Executing " + this);
        return new CommandResult();
    }

    public void execute(String input, DietStorage storage) throws InvalidCommandWordException,
            InvalidCommandFormatException, InvalidDateFormatException, InvalidSearchDateException {
        return;
    }

    public void execute(String input, ArrayList<Food> foodList,
                        DietStorage storage) throws InvalidCommandWordException {
        return;
    }

    public void execute(String[] inputs, ExerciseList exerciseList,
                        String filePath, storage.workout.Storage storage,
                        boolean[] hasEndedWorkoutSessions) throws InvalidCommandWordException {
        return;
    }
}
