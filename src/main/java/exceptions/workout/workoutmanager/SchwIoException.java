package exceptions.workout.workoutmanager;

import exceptions.SchwarzeneggerException;

public class SchwIoException extends SchwarzeneggerException {

    /**
     * Constructs SchwIoException object inheriting abstract class SchwarzeneggerException.
     */
    public SchwIoException(String content) {
        super(content);
    }
}
