package exceptions;

import static ui.profile.ProfileUi.MESSAGE_END;

public class EndException extends SchwarzeneggerException {

    /**
     * Constructs EndException object inheriting abstract class SchwarzeneggerException.
     */
    public EndException() {
        super(MESSAGE_END);
    }
}
