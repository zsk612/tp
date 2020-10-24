package commands.workout.workoutsession;

import commands.Command;
import exceptions.InvalidCommandWordException;
import storage.workout.Storage;
import workout.workoutsession.exercise.ExerciseList;


public class WorkoutSessionWrong extends Command {
    @Override
    public void execute(String[] inputs, ExerciseList exerciseList,
                        String filePath, Storage storage,
                        boolean[] hasEndedWorkoutSessions) throws InvalidCommandWordException {
        throw new InvalidCommandWordException();
    }
}
