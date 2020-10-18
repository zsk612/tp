package commands.workout.workoutmanager.command;

import commands.Command;
import storage.workout.WorkOutManagerStorage;

public class ListWS extends Command {
    @Override
    public void execute(String[] args) {
        WorkOutManagerStorage.list(args);
        logger.info("listed successfully");
    }
}
