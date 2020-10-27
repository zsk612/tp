package commands.workout.workoutsession;

import commands.Command;
import exceptions.SchwarzeneggerException;
import models.Exercise;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.WorkoutSessionParser;
import models.ExerciseList;

import java.io.IOException;

public class WorkoutSessionDelete extends Command {
    public void execute(String[] inputs, ExerciseList exerciseList,
                        String filePath, Storage storage, boolean[] hasEndedWorkoutSessions) {
        try {
            int removeIndex = WorkoutSessionParser.deleteParser(inputs);
            Exercise deletedExercise = exerciseList.exerciseList.get(removeIndex - 1);
            exerciseList.exerciseList.remove(removeIndex - 1);
            storage.writeToStorage(filePath, exerciseList);
            WorkoutSessionUi.deleteExerciseSuccess(deletedExercise);
        } catch (IOException e) {
            WorkoutSessionUi.printError();
        } catch (ArrayIndexOutOfBoundsException e) {
            WorkoutSessionUi.deleteFormatError();
        } catch (IndexOutOfBoundsException e) {
            WorkoutSessionUi.deleteIndexError();
        } catch (SchwarzeneggerException e) {
            WorkoutSessionUi.deleteFormatError();
        }
    }
}
