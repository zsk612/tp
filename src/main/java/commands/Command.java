package commands;

import diet.dietsession.Food;
import storage.diet.Storage;
import workout.workoutsession.exercise.Exercise;

import java.util.ArrayList;

import static commands.ExecutionResult.SKIPPED;

public abstract class Command {

    public ExecutionResult execute(String[] args) {
        return SKIPPED;
    }

    public void execute(String input, Storage storage) {
        return;
    }

    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
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
