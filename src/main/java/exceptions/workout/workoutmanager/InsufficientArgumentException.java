package exceptions.workout.workoutmanager;

import exceptions.SchwarzeneggerException;

import static ui.workout.workoutmanager.WorkoutManagerUi.MESSAGE_INSUFFICIENT_ARGUMENT;

/**
 * Represents exception when user inputs insufficient arguments to command.
 */
public class InsufficientArgumentException extends SchwarzeneggerException {

    /**
     * Constructs InsufficientArgumentException object inheriting abstract class SchwarzeneggerException.
     */
    public InsufficientArgumentException() {
        super(MESSAGE_INSUFFICIENT_ARGUMENT);
    }
}
