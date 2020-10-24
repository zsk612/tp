package commands.workout.workoutsession;

import commands.Command;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.WorkoutSessionParser;
import workout.workoutsession.exercise.ExerciseList;

import java.io.IOException;

public class WorkoutSessionDelete extends Command {
    public void execute(String[] inputs, ExerciseList exerciseList,
                        String filePath, Storage storage, boolean[] hasEndedWorkoutSessions) {
        try {
            int removeIndex = WorkoutSessionParser.deleteParser(inputs);
            if (removeIndex != 0) {
                exerciseList.exerciseList.remove(removeIndex - 1);
                storage.writeToStorage(filePath, exerciseList);
            } else {
                WorkoutSessionUi.deleteIndexError();
            }
        } catch (IOException e) {
            WorkoutSessionUi.printError();
        } catch (IndexOutOfBoundsException e) {
            WorkoutSessionUi.deleteIndexError();
        }
    }
}
