package commands.workout.workoutsession;

import commands.Command;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.WorkoutSessionParser;
import workout.workoutsession.exercise.Exercise;

import java.io.IOException;
import java.util.ArrayList;

public class WorkoutSessionDelete extends Command {
    public void execute(String[] inputs, ArrayList<Exercise> exerciseList,
                        String filePath, Storage storage, boolean[] hasEndedWorkoutSessions) {
        try {
            int removeIndex = WorkoutSessionParser.deleteParser(inputs);
            if (removeIndex != 0) {
                exerciseList.remove(removeIndex - 1);
                storage.writeToStorage(filePath, exerciseList);
            }
        } catch (IOException e) {
            WorkoutSessionUi.printError();
        } catch (IndexOutOfBoundsException e) {
            WorkoutSessionUi.deleteIndexError();
        }
    }
}
