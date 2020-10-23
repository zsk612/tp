package commands.main;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import ui.CommonUi;
import ui.diet.dietsession.DietSessionUi;
import workout.workoutmanager.WorkoutManager;

public class ToWorkout extends Command {

    CommonUi ui = new CommonUi();

    @Override
    public CommandResult execute(String[] args) {
        ui.showToUser("Entering Workout Session...");
        WorkoutManager workoutManager = new WorkoutManager();
        workoutManager.start();
        return new CommandResult("", ExecutionResult.OK);
    }
}
