package commands;

import diet.dietsession.Food;
import exceptions.SchwarzeneggerException;
import profile.Profile;
import storage.diet.Storage;
import workout.workoutsession.exercise.Exercise;

import java.util.ArrayList;

import static commands.ExecutionResult.SKIPPED;

public abstract class Command {

    public CommandResult execute(String[] args) throws SchwarzeneggerException {
        return new CommandResult();
    }

    public Profile execute(Profile profile) throws SchwarzeneggerException {
        return profile;
    }

    public void execute(String input, Storage storage) {
        return;
    }

    public void execute(String input, ArrayList<Food> foodList, Storage storage) {
        return;
    }

    public void execute(String[] inputs, ArrayList<Exercise> exerciseList,
                        String filePath, storage.workout.Storage storage, boolean[] hasEndedWorkoutSessions) {
        return;
    }

    public CommandResult getExecutionResult(Profile profile) {
        return null;
    }
}
