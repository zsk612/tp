package commands;

import diet.dietsession.Food;
import exceptions.InvalidCommandWordException;
import exceptions.InvalidDateFormatException;
import exceptions.SchwarzeneggerException;
import exceptions.diet.InvalidSearchDateException;
import exceptions.profile.InvalidCommandFormatException;
import logger.SchwarzeneggerLogger;
import models.ExerciseList;
import storage.diet.DietStorage;
import storage.profile.ProfileStorage;
import ui.CommonUi;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A base class for command.
 */
public abstract class Command {

    protected static Logger logger = SchwarzeneggerLogger.getInstanceLogger();
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
     * @return An object CommandResult containing the executing status and feedback message to be displayed
     *         to user.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    public CommandResult execute(String commandArgs, ProfileStorage storage) throws SchwarzeneggerException {
        logger.log(Level.INFO, "Executing " + this);
        return new CommandResult();
    }

    /**
     * Executes the command with user's input.
     *
     * @param input User's input for command.
     * @param storage Diet Storage to load and save data.
     * @throws InvalidCommandWordException If command word is invalid.
     * @throws InvalidCommandFormatException If command format is invalid.
     * @throws InvalidDateFormatException If date format is invalid.
     * @throws InvalidSearchDateException If search date is invalid.
     */
    public CommandResult execute(String input, DietStorage storage) throws InvalidCommandWordException,
            InvalidCommandFormatException, InvalidDateFormatException, InvalidSearchDateException {
        return new CommandResult();
    }

    /**
     * Executes the command with user's input.
     *
     * @param input User's input for command.
     * @param storage Diet Storage to load and save data.
     * @param index Integer variable that shows the index of diet session
     * @throws InvalidCommandWordException If command word is invalid.
     */
    public void execute(String input, ArrayList<Food> foodList,
                        DietStorage storage, Integer index) throws InvalidCommandWordException {
        return;
    }

    /**
     * Executes the command with user's input.
     *
     * @param inputs Array of user's input.
     * @param exerciseList List of exercise.
     * @param filePath Path to data file.
     * @param storage Workout Session Storage to load and save data.
     * @param hasEndedWorkoutSessions Array of booleans indicating if user has ended workout sessions.
     * @throws InvalidCommandWordException If command word is invalid.
     */
    public void execute(String[] inputs, ExerciseList exerciseList,
                        String filePath, storage.workout.Storage storage,
                        boolean[] hasEndedWorkoutSessions) throws InvalidCommandWordException {
        return;
    }
}
