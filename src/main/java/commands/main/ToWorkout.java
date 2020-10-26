package commands.main;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import workout.workoutmanager.WorkoutManager;

public class ToWorkout extends Command {

    /**
     * Executes redirecting to Workout Menu command from Main Menu.
     *
     * @param args User's input.
     * @return Redirecting to Workout Menu message.
     */
    @Override
    public CommandResult execute(String args) {
        ui.printOpening("Workout menu");
        WorkoutManager workoutManager = new WorkoutManager();
        workoutManager.start();
        ui.printReturning("Main menu");
        return new CommandResult("", ExecutionResult.OK);
    }
}
