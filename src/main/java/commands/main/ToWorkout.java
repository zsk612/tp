package commands.main;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import workout.workoutmanager.WorkoutManager;

public class ToWorkout extends Command {

    @Override
    public CommandResult execute(String[] args) {
        System.out.println("Entering Workout Session...");
        WorkoutManager workoutManager = new WorkoutManager();
        workoutManager.start();
        return new CommandResult("", ExecutionResult.OK);
    }
}
