package workout.workoutmanager.command;

import storage.Workout.WorkOutManagerStorage;

public class WorkoutSessionList implements Command {
    @Override
    public void execute(String[] args) {
        WorkOutManagerStorage.list(args);
    }
}
