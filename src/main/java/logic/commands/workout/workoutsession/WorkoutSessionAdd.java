package logic.commands.workout.workoutsession;

import logic.commands.Command;
import exceptions.workout.workoutsession.AddFormatException;
import models.Exercise;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.WorkoutSessionParser;
import models.ExerciseList;

import java.io.IOException;


public class WorkoutSessionAdd extends Command {

    @Override
    public void execute(String[] inputs, ExerciseList exerciseList,
                        String filePath, Storage storage, boolean[] hasEndedWorkoutSessions) {
        try {
            exerciseList.exerciseList.add(WorkoutSessionParser.addParser(inputs));
            storage.writeToStorage(filePath, exerciseList);
            Exercise addedExercise = exerciseList.exerciseList.get(exerciseList.exerciseList.size() - 1);
            WorkoutSessionUi.addExerciseSuccess(addedExercise);
        } catch (NumberFormatException e) {
            WorkoutSessionUi.addFormatError();
        } catch (IOException e) {
            WorkoutSessionUi.printError();
        } catch (AddFormatException e) {
            WorkoutSessionUi.addFormatNegativeError();
        }
    }
}
