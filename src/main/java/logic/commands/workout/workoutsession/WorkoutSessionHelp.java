package logic.commands.workout.workoutsession;

import logic.commands.Command;
import logic.commands.CommandResult;
import storage.workout.WorkoutSessionStorage;
import ui.workout.workoutsession.WorkoutSessionUi;
import models.ExerciseList;

//@@author yujinyang1998
public class WorkoutSessionHelp extends Command {
    @Override
    public CommandResult execute(String[] inputs, ExerciseList exerciseList,
                                 String filePath, WorkoutSessionStorage workoutSessionStorage,
                                 boolean[] hasEndedWorkoutSessions) {
        assert (inputs != null && exerciseList != null && filePath != null
                && workoutSessionStorage != null && hasEndedWorkoutSessions != null) : "File Corrupted";
        String showToUser = WorkoutSessionUi.printHelp();
        return new CommandResult(showToUser);
    }
}
