package commands.main;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import workout.workoutmanager.WorkoutManager;

public class ToWorkout extends Command {

    /**
     * Executes redirecting to Workout Menu command from Main Menu.
     *
     * @param args Array of user's input.
     * @return Redirecting to Workout Menu message.
     */
    @Override
    public CommandResult execute(String args) {
        ui.showToUser("Entering Workout Session...");
        WorkoutManager workoutManager = new WorkoutManager();
        workoutManager.start();
        return new CommandResult("", ExecutionResult.OK);
    }
}
