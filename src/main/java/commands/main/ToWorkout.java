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
        if (!args.isEmpty()) {
            ui.showWarning("\"workout\" command does not take in parameters");
        }

        WorkoutManager workoutManager = new WorkoutManager();
        workoutManager.start();

        return new CommandResult("", ExecutionResult.OK);
    }
}
