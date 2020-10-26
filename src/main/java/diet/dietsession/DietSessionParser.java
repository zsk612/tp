package diet.dietsession;

import exceptions.diet.NegativeCaloriesException;
import exceptions.profile.InvalidCaloriesException;
import logger.SchwarzeneggerLogger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DietSessionParser {
    private static Logger logger = SchwarzeneggerLogger.getInstanceLogger();

    public String[] parse(String comm) {
        if (comm.contains(" ")) {
            return comm.split(" ", 2);
        } else {
            return new String[]{comm, "filler"};
        }
    }

    /**
     * Processes the name of the food item.
     *
     * @param food string for food content
     * @return food name
     * @throws IndexOutOfBoundsException handles exception for not inputting food name or calories
     */
    public String processFoodName(String food) throws IndexOutOfBoundsException {
        String[] temp = food.trim().split("/c", 2);
        return temp[0].trim();
    }

    /**
     * Processes the calories of the food item.
     *
     * @param food string for food content
     * @return food calories
     * @throws NumberFormatException handles exception for wrong calories input
     */
    public double processFoodCalories(String food) throws NumberFormatException, NegativeCaloriesException {
        String[] temp = food.trim().split("/c", 2);
        if (Double.parseDouble(temp[1]) < 0) {
            throw new NegativeCaloriesException();
        }
        logger.log(Level.INFO, "Processed food calories successfully");
        return Double.parseDouble(temp[1]);
    }


}
