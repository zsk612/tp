package commands;

import commands.workout.workoutmanager.ExecutionResult;
import diet.dietsession.Food;
import storage.diet.Storage;
import workout.workoutsession.exercise.Exercise;

import java.util.ArrayList;
import java.util.logging.Logger;

import static commands.workout.workoutmanager.ExecutionResult.SKIPPED;

public abstract class Command {

    protected static final Logger logger = Logger.getLogger("java.workout.command");

    public ExecutionResult execute(String[] args) {
        return SKIPPED;
    }

    public void execute(String input, Storage storage, Logger logger) {
        return;
    }

    public void execute(String input, ArrayList<Food> foodList, Storage storage, Logger logger) {
        return;
    }

    public void execute(String[] input, ArrayList<Exercise> exercise,
                        String filePath, storage.workout.Storage storage, boolean[] endWorkoutSession) {
        return;
    }

    public void printResponse() {
        return;
    }
}
