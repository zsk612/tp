package commands.workout.workoutsession;

import commands.Command;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.exercise.ExerciseList;

import java.io.IOException;

public class WorkoutSessionEnd extends Command {
    public void execute(String[] inputs, ExerciseList exerciseList,
                        String filePath, Storage storage, boolean[] hasEndedWorkoutSessions) {
        setEndWorkoutSessionT(hasEndedWorkoutSessions);
        try {
            storage.writeToStorage(filePath, exerciseList);
        } catch (IOException e) {
            WorkoutSessionUi.printError();
        }
    }

    private void setEndWorkoutSessionT(boolean[] hasEndedWorkoutSessions) {
        hasEndedWorkoutSessions[0] = true;
    }


}
