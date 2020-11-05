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
        String showToUser = "";
        try {
            int removeIndex = WorkoutSessionParser.deleteParser(inputs);
            Exercise deletedExercise = exerciseList.exerciseList.get(removeIndex - 1);
            exerciseList.exerciseList.remove(removeIndex - 1);
            storage.writeToStorage(filePath, exerciseList);
            showToUser = WorkoutSessionUi.deleteExerciseSuccess(deletedExercise);
        } catch (IOException e) {
            return new CommandResult(WorkoutSessionUi.printError());
        } catch (ArrayIndexOutOfBoundsException e) {
            return new CommandResult(WorkoutSessionUi.deleteFormatError());
        } catch (IndexOutOfBoundsException e) {
            return new CommandResult(WorkoutSessionUi.deleteIndexError());
        } catch (SchwarzeneggerException e) {
            return new CommandResult(WorkoutSessionUi.deleteFormatError());
        }
        return new CommandResult(showToUser);
    }
}
