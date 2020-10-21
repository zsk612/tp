package commands.workout.workoutsession;

import commands.Command;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import workout.workoutsession.exercise.Exercise;

import java.io.IOException;
import java.util.ArrayList;

public class WorkoutSessionList extends Command {

    @Override
    public void execute(String[] inputs, ArrayList<Exercise> exerciseList,
                        String filePath, Storage storage, boolean[] hasEndedWorkoutSessions) {
        printList(exerciseList);
        try {
            storage.writeToStorage(filePath, exerciseList);
        } catch (IOException e) {
            WorkoutSessionUi.printError();
        }
    }

    private void printList(ArrayList<Exercise> exercise) {
        if (exercise.size() <= 0) {
            WorkoutSessionUi.emptyListError();
        }
        for (int i = 0; i < exercise.size(); i++) {
            System.out.println((i + 1) + ": " + exercise.get(i).toString());
        }
    }
}
