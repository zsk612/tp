package commands.workout.workoutsession;

import commands.Command;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.exercise.Exercise;

import java.util.ArrayList;

public class WorkoutSessionWrong extends Command {
    @Override
    public void execute(String[] inputs, ArrayList<Exercise> exerciseList,
                        String filePath, Storage storage, boolean[] hasEndedWorkoutSessions) {
        WorkoutSessionUi.inputNotRecognisedError();
    }
}
