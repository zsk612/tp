package workout.workoutmanager.command;

import java.util.logging.Logger;

public abstract class Command {

    protected static final Logger logger = Logger.getLogger("java.workout.command");

    public abstract void execute(String[] args);
}
