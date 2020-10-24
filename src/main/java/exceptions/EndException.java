package exceptions;

import static profile.Constants.MESSAGE_END;

public class EndException extends SchwarzeneggerException {

    public EndException() {
        super(MESSAGE_END);
    }
}
