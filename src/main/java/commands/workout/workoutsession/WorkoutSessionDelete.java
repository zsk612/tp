package commands.workout.workoutsession;

import commands.Command;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.WorkoutSessionParser;
import workout.workoutsession.exercise.Exercise;

import java.io.IOException;
import java.util.ArrayList;

public class WorkoutSessionDelete extends Command {
    public void execute(String[] input, ArrayList<Exercise> exerciseList, String filePath, Storage storage, boolean[] endWorkoutSession) {
        exerciseList.remove(WorkoutSessionParser.deleteParser(input));
        try {
            storage.writeToStorage(filePath, exerciseList);
        } catch (IOException e) {
            WorkoutSessionUi.printError();
        }
    }
}
