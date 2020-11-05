package logic.commands.workout.workoutsession;

import logic.commands.Command;
import logic.commands.CommandResult;
import storage.workout.Storage;
import ui.workout.workoutsession.WorkoutSessionUi;
import models.ExerciseList;


public class WorkoutSessionHelp extends Command {
    @Override
    public CommandResult execute(String[] inputs, ExerciseList exerciseList,
                                 String filePath, Storage storage, boolean[] hasEndedWorkoutSessions) {
        String showToUser =  WorkoutSessionUi.printHelp();
        return new CommandResult(showToUser);
    }
}
