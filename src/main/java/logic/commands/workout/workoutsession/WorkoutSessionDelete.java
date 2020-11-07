package logic.commands.workout.workoutsession;

import logic.commands.Command;
import exceptions.SchwarzeneggerException;
import logic.commands.CommandResult;
import models.Exercise;
import storage.workout.WorkoutSessionStorage;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.WorkoutSessionParser;
import models.ExerciseList;

import java.io.IOException;

public class WorkoutSessionDelete extends Command {
    public CommandResult execute(String[] inputs, ExerciseList exerciseList,
                                 String filePath, WorkoutSessionStorage workoutSessionStorage,
                                 boolean[] hasEndedWorkoutSessions) {
        assert (inputs != null && exerciseList != null && filePath != null
                && workoutSessionStorage != null && hasEndedWorkoutSessions != null) : "File Corrupted";
        String result = "";
        try {
            int removeIndex = WorkoutSessionParser.deleteParser(inputs);
            Exercise deletedExercise = exerciseList.exerciseList.get(removeIndex - 1);
            exerciseList.exerciseList.remove(removeIndex - 1);
            workoutSessionStorage.writeToStorage(filePath, exerciseList);
            result = WorkoutSessionUi.deleteExerciseSuccess(deletedExercise);
        } catch (IOException e) {
            return new CommandResult(WorkoutSessionUi.PRINT_ERROR);
        } catch (ArrayIndexOutOfBoundsException e) {
            return new CommandResult(WorkoutSessionUi.DELETE_FORMAT_ERROR);
        } catch (IndexOutOfBoundsException e) {
            return new CommandResult(WorkoutSessionUi.DELETE_INDEX_ERROR);
        } catch (SchwarzeneggerException e) {
            return new CommandResult(WorkoutSessionUi.DELETE_FORMAT_ERROR);
        }
        return new CommandResult(result);
    }
}
