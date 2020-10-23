package exceptions.workoutmanager;

import exceptions.SchwarzeneggerException;

public class SchwIoException extends SchwarzeneggerException {

    public SchwIoException(String content) {
        super(content);
    }
}
