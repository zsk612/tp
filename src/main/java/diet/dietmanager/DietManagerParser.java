package diet.dietmanager;

import diet.DateParser;
import exceptions.InvalidDateFormatException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DietManagerParser {

    /**
     * Parses user input to extract command words and instructions.
     *
     * @param comm user input for command
     * @return a string array containing command words and instructions
     */
    public String[] parse(String comm) {
        if (comm.contains(" ")) {
            return comm.split(" ", 2);
        } else {
            return new String[]{comm, "filler"};
        }
    }

    /**
     * Extracts out date and time by looking for date strings in YYYY-MM-DD format.
     *
     * @param input user input for new diet session
     * @param extractDateMessage string builder that appends warnings and messages
     * @return date in MMM dd yyyy if the user inputs date in YYYY-MM-DD format;
     *         else returns original string
     * @throws DateTimeParseException if the date string input is not a valid date
     */
    public String extractDate(String input, StringBuilder extractDateMessage) throws DateTimeParseException,
            IllegalStateException,
            InvalidDateFormatException {
        try {
            String dateString = input.split("/t")[0].split(" ", 2)[1].trim();
            return DateParser.parseDate(dateString).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        } catch (IndexOutOfBoundsException e) {
            extractDateMessage.append("I do not understand your date input!\n");
        } catch (NullPointerException e) {
            extractDateMessage.append("It looks like there is no date input\n");
        }
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        extractDateMessage.append("\t I've replaced it with today's date.\n");
        return dtf.format(now);
    }

    /**
     * Extracts out tag of the diet session.
     *
     * @param input user input for new diet session
     * @param extractMealMessage string builder that appends warnings and messages
     * @return tag input if there is any;
     *         else returns "unspecified"
     * @throws IndexOutOfBoundsException if there is no input for tag
     * @throws NullPointerException if there is no input for tag
     */
    public String extractMeal(String input, StringBuilder extractMealMessage)
            throws IndexOutOfBoundsException, NullPointerException {
        try {
            return input.split("/t")[1].trim();
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            if (!extractMealMessage.toString().isEmpty()) {
                extractMealMessage.append("\t ");
            }
            extractMealMessage.append("Please specify your diet session tag, i.e. breakfast, lunch, dinner\n");
        }
        extractMealMessage.append("\t Session is tagged as unspecified.");
        return "unspecified";
    }
}
