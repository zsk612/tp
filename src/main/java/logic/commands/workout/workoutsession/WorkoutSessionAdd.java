package logic.commands.workout.workoutsession;

import logic.commands.Command;
import exceptions.workout.workoutsession.AddFormatException;
import logic.commands.CommandResult;
import models.Exercise;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.WorkoutSessionParser;
import models.ExerciseList;

import java.io.IOException;


public class WorkoutSessionAdd extends Command {

    @Override
    public CommandResult execute(String[] inputs, ExerciseList exerciseList,
                                 String filePath, Storage storage, boolean[] hasEndedWorkoutSessions) {
        String result = "";
        try {
            exerciseList.exerciseList.add(WorkoutSessionParser.addParser(inputs));
            storage.writeToStorage(filePath, exerciseList);
            Exercise addedExercise = exerciseList.exerciseList.get(exerciseList.exerciseList.size() - 1);
            result = WorkoutSessionUi.addExerciseSuccess(addedExercise);
        } catch (NumberFormatException e) {
            return new CommandResult(WorkoutSessionUi.ADD_FORMAT_ERROR);
        } catch (IOException e) {
            return new CommandResult(WorkoutSessionUi.PRINT_ERROR);
        } catch (AddFormatException e) {
            return new CommandResult(WorkoutSessionUi.ADD_FORMAT_NEGATIVE_ERROR);
        }
        return new CommandResult(result);
    }
}
