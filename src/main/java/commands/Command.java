package commands;

import diet.dietsession.Food;
import exceptions.SchwarzeneggerException;
import profile.Profile;
import storage.diet.DietStorage;
import workout.workoutsession.exercise.ExerciseList;

import java.util.ArrayList;

public abstract class Command {

    public CommandResult execute(String[] args) throws SchwarzeneggerException {
        return new CommandResult();
    }

    public Profile execute(Profile profile) throws SchwarzeneggerException {
        return profile;
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

    public CommandResult getExecutionResult(Profile profile) {
        return null;
    }
}
