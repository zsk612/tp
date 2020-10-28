package commands.main;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import workout.workoutmanager.WorkoutManager;

/**
 * A representation of the command for redirecting to Workout Menu from Main Menu.
 */
public class ToWorkout extends Command {

    /**
     * Executes redirecting to Workout Menu command from Main Menu.
     *
     * @param args User's input.
     * @return Redirecting to Workout Menu message.
     */
    @Override
    public CommandResult execute(String args) {
        ui.printOpening("Workout Menu");
        WorkoutManager workoutManager = new WorkoutManager();
        workoutManager.start();
        ui.printReturning("Main Menu");
        return new CommandResult("", ExecutionResult.OK);
    }
}
