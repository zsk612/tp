package commands.workout.workoutsession;

import commands.Command;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.exercise.Exercise;

import java.util.ArrayList;

public class WorkoutSessionSearch extends Command {
    @Override
    public void execute(String[] input, ArrayList<Exercise> exercise,
                        String filePath, Storage storage, boolean[] endWorkoutSession) {
        WorkoutSessionUi.printHelp();
    }
}
