package commands;

import diet.dietsession.Food;
import exceptions.SchwarzeneggerException;
import logger.SchwarzeneggerLogger;
import profile.Profile;
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
     * Execute the command with given arguments.
     * @param args user inputs into a list of string
     * @return An object CommandResult containing the executing status and feedback message to be displayed
     *         to user
     * @throws SchwarzeneggerException If encounter any error in execution, the exception is thrown and
     *         handled with customised handler
     */
    public CommandResult execute(String[] args) throws SchwarzeneggerException {
        logger.log(Level.INFO, "Executing " + this);
        return new CommandResult();
    }

    public CommandResult execute(String input, ProfileStorage storage) throws SchwarzeneggerException {
        return new CommandResult();
    }

    public void execute(String input, DietStorage storage) {
        return;
    }

    public void execute(String input, ArrayList<Food> foodList, DietStorage storage) {
        return;
    }

    public void execute(String[] inputs, ExerciseList exerciseList,
                        String filePath, storage.workout.Storage storage, boolean[] hasEndedWorkoutSessions) {
        return;
    }
}
