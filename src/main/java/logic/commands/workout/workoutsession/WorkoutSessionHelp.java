package logic.commands.workout.workoutsession;

import logic.commands.Command;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import models.ExerciseList;


public class WorkoutSessionHelp extends Command {
    @Override
    public void execute(String[] inputs, ExerciseList exerciseList,
                        String filePath, Storage storage, boolean[] hasEndedWorkoutSessions) {
        WorkoutSessionUi.printHelp();
    }
}
