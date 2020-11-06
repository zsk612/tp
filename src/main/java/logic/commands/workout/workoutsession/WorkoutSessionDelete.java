package logic.commands.workout.workoutsession;

import logic.commands.Command;
import exceptions.SchwarzeneggerException;
import logic.commands.CommandResult;
import models.Exercise;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.WorkoutSessionParser;
import models.ExerciseList;

import java.io.IOException;

public class WorkoutSessionDelete extends Command {
    public CommandResult execute(String[] inputs, ExerciseList exerciseList,
                                 String filePath, Storage storage, boolean[] hasEndedWorkoutSessions) {
        String result = "";
        try {
            int removeIndex = WorkoutSessionParser.deleteParser(inputs);
            Exercise deletedExercise = exerciseList.exerciseList.get(removeIndex - 1);
            exerciseList.exerciseList.remove(removeIndex - 1);
            storage.writeToStorage(filePath, exerciseList);
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
