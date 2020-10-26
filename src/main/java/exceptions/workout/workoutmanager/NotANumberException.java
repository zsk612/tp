package exceptions.workout.workoutmanager;

import exceptions.SchwarzeneggerException;

import static ui.workout.workoutmanager.WorkoutManagerUi.MESSAGE_NOT_A_NUMBER;

public class NotANumberException extends SchwarzeneggerException {

    /**
     * Constructs NotANumberException object inheriting abstract class SchwarzeneggerException.
     */
    public NotANumberException() {
        super(MESSAGE_NOT_A_NUMBER);
    }
}
