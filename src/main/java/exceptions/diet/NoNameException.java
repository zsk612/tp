package exceptions.diet;

import exceptions.SchwarzeneggerException;

import static ui.diet.dietsession.DietSessionUi.MESSAGE_NO_FOOD_NAME;

public class NoNameException extends SchwarzeneggerException {

    /**
     * Constructs SchwarzeneggerException object inheriting class Exception.
     */
    public NoNameException() {
        super(MESSAGE_NO_FOOD_NAME);
    }
}
