package workout.workoutmanager.command;

import workout.workoutmanager.ExitException;
import workout.workoutmanager.WorkoutManagerUI;

public class ByeWS extends Command {

    @Override
    public void execute(String[] args) {
        logger.info("bye command carried out");
        WorkoutManagerUI.printBye();
        throw new ExitException();
    }
}
