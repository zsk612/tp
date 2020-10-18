package commands.workout.workoutsession;

import commands.Command;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.WorkoutSessionParser;
import workout.workoutsession.exercise.Exercise;

import java.io.IOException;
import java.util.ArrayList;

public class WorkoutSessionAdd extends Command {

    @Override
    public void execute(String[] input, ArrayList<Exercise> exercise, String filePath, Storage storage, boolean[] endWorkoutSession) {
        try {
            exercise.add(WorkoutSessionParser.addParser(input));
            storage.writeToStorage(filePath, exercise);
        } catch (NumberFormatException e) {
            WorkoutSessionUi.addFormatError();
        } catch (IOException e) {
            WorkoutSessionUi.printError();
        }
    }
}
