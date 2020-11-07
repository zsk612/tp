package logic.commands.workout.workoutsession;

import logic.commands.Command;
import exceptions.InvalidCommandWordException;
import logic.commands.CommandResult;
import storage.workout.Storage;
import models.ExerciseList;


public class WorkoutSessionWrong extends Command {
    @Override
    public CommandResult execute(String[] inputs, ExerciseList exerciseList,
                                 String filePath, Storage storage,
                                 boolean[] hasEndedWorkoutSessions) throws InvalidCommandWordException {
        throw new InvalidCommandWordException();
    }
}
