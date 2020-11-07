package logic.commands.workout.workoutsession;

import logic.commands.Command;
import logic.commands.CommandResult;
import storage.workout.WorkoutSessionStorage;
import ui.workout.workoutsession.WorkoutSessionUi;
import models.ExerciseList;

import java.io.IOException;

//@@author yujinyang1998
public class WorkoutSessionEnd extends Command {
    public CommandResult execute(String[] inputs, ExerciseList exerciseList,
                                 String filePath, WorkoutSessionStorage workoutSessionStorage,
                                 boolean[] hasEndedWorkoutSessions) {
        assert (inputs != null && exerciseList != null && filePath != null
                && workoutSessionStorage != null && hasEndedWorkoutSessions != null) : "File Corrupted";
        setEndWorkoutSessionT(hasEndedWorkoutSessions);
        try {
            workoutSessionStorage.writeToStorage(filePath, exerciseList);
        } catch (IOException e) {
            return new CommandResult(WorkoutSessionUi.PRINT_ERROR);
        }
        return new CommandResult();
    }

    private void setEndWorkoutSessionT(boolean[] hasEndedWorkoutSessions) {
        hasEndedWorkoutSessions[0] = true;
    }


}
