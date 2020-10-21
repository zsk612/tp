package diet.dietsession;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;

import static logger.SchwarzeneggerLogger.logger;

public class DietSessionParser {
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
        return temp[0];
    }

    /**
     * Processes the calories of the food item.
     *
     * @param food string for food content
     * @return food calories
     * @throws NumberFormatException handles exception for wrong calories input
     */
    public double processFoodCalories(String food) throws NumberFormatException {
        String[] temp = food.trim().split("/c", 2);
        logger.log(Level.INFO, "Processed food calories successfully");
        return Double.parseDouble(temp[1]);
    }

    /**
     * Converts the date and time into a LocalDate object.
     *
     * @param dateInput Date input string
     * @return LocalDate object
     */
    public LocalDate parseDate(String dateInput) {

        DateTimeFormatter formatterA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterB = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        DateTimeFormatter formatterC = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        LocalDate date = null;
        try {
            date = LocalDate.parse(dateInput, formatterA);
            logger.log(Level.INFO, "Parsed date and time successfully");

        } catch (DateTimeParseException e) {
            System.out.println("Invalid input for date and time.");
            logger.log(Level.WARNING, "Unable to parse date and time");
        }
        try {
            if (date == null) {
                date = LocalDate.parse(dateInput, formatterB);
                logger.log(Level.INFO, "Parsed date and time successfully");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid input for date and time.");
            logger.log(Level.WARNING, "Unable to parse date and time");
        }
        try {
            if (date == null) {
                date = LocalDate.parse(dateInput, formatterC);
                logger.log(Level.INFO, "Parsed date and time successfully");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid input for date and time.");
            logger.log(Level.WARNING, "Unable to parse date and time");
        }
        try {
            if (date == null) {
                date = LocalDate.parse(dateInput);
                logger.log(Level.INFO, "Parsed date and time successfully");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Invalid input for date and time.");
            logger.log(Level.WARNING, "Unable to parse date and time");
        }
        return null;
    }
}
