package logic.commands.workout.workoutsession;

import logic.commands.Command;
import exceptions.InvalidCommandWordException;
import logic.commands.CommandResult;
import storage.workout.WorkoutSessionStorage;
import models.ExerciseList;

//@@author yujinyang1998
public class WorkoutSessionWrong extends Command {
    @Override
    public CommandResult execute(String[] inputs, ExerciseList exerciseList,
                                 String filePath, WorkoutSessionStorage workoutSessionStorage,
                                 boolean[] hasEndedWorkoutSessions) throws InvalidCommandWordException {
        assert (exerciseList != null && filePath != null && workoutSessionStorage != null
                && hasEndedWorkoutSessions != null) : "File Corrupted";
        throw new InvalidCommandWordException();
    }
}
