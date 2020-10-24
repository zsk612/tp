package exceptions.workoutmanager;

import exceptions.SchwarzeneggerException;

import static ui.workout.workoutmanager.WorkoutManagerUi.MESSAGE_INSUFFICIENT_ARGUMENT;

public class InsufficientArgumentException extends SchwarzeneggerException {

    /**
     * Constructs InsufficientArgumentException object inheriting abstract class SchwarzeneggerException.
     */
    public InsufficientArgumentException() {
        super(MESSAGE_INSUFFICIENT_ARGUMENT);
    }
}
