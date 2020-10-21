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
    public void execute(String[] inputs, ArrayList<Exercise> exerciseList,
                        String filePath, Storage storage, boolean[] hasEndedWorkoutSessions) {
        try {
            exerciseList.add(WorkoutSessionParser.addParser(inputs));
            storage.writeToStorage(filePath, exerciseList);
        } catch (NumberFormatException e) {
            WorkoutSessionUi.addFormatError();
        } catch (IOException e) {
            WorkoutSessionUi.printError();
        }
    }
}
