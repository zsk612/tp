package diet.dietmanager;

import diet.DateParser;
import exceptions.InvalidDateFormatException;
import exceptions.profile.InvalidCommandFormatException;
import logger.SchwarzeneggerLogger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static seedu.duke.Constant.COMMAND_WORD_HELP;
import static seedu.duke.Constant.COMMAND_WORD_SEARCH;

public class DietManagerParser {

    public Logger logger = SchwarzeneggerLogger.getInstanceLogger();

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

    public HashMap<String, String> extractDietManagerCommandTagAndInfo(String command, String commandArgs)
            throws InvalidCommandFormatException {

        HashMap<String, String> parsedParams = new HashMap<>();
        int startIndex = 0;
        int endIndex = 0;
        if (commandArgs.isEmpty() || !(commandArgs.contains("/t")
                || commandArgs.contains("/s") || commandArgs.contains("/e"))) {
            throw new InvalidCommandFormatException("Wrong format , please enter in the format:\n\t "
                    + "search /s [STARTING _DATE] /e [END_DATE] /t [TAG]");
        }

        try {
            while (commandArgs.indexOf("/", startIndex) != -1) {
                endIndex = commandArgs.indexOf("/", startIndex + 1);

                if (endIndex == -1) {
                    endIndex = commandArgs.length();
                }

                String parsedOption = commandArgs.substring(startIndex + 2, endIndex).trim();
                String optionIndicator = commandArgs.substring(startIndex, startIndex + 2).trim().toLowerCase();
                parsedParams.put(optionIndicator, parsedOption);

                startIndex = endIndex;
            }

            return parsedParams;
        } catch (StringIndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "Wrong format for search input");
            throw new InvalidCommandFormatException("Wrong format , please enter in the format:\n\t "
                    + "search /s [STARTING _DATE] /e [END_DATE] /t [TAG]");
        }
    }

    public String extractSearchTag(HashMap<String, String> parsedParams, StringBuilder searchResult) {
        try {
            String tag = parsedParams.get("/t").trim();
            return tag;
        } catch (NullPointerException e) {
            logger.log(Level.WARNING, "It looks like there is no date input for search tag");
        }
        return "";
    }

    public LocalDateTime extractStartDates(HashMap<String, String> parsedParams, StringBuilder searchResult)
            throws InvalidDateFormatException {

        try {
            String startDate = parsedParams.get("/s");
            return DateParser.parseDate(startDate);

        } catch (IndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "I do not understand your date input in start date");
        } catch (NullPointerException e) {
            logger.log(Level.WARNING, "It looks like there is no date input in start date");
        } catch (InvalidDateFormatException e) {
            logger.log(Level.WARNING, "Invalid date in start date");
            throw new InvalidDateFormatException();
        }
        searchResult.append("Starting date is empty, "
                + "and it is replaced with the earliest date.\n\t ");
        return DateParser.parseDate("0001-01-01");
    }

    public LocalDateTime extractEndDates(HashMap<String, String> parsedParams, StringBuilder searchResult)
            throws InvalidDateFormatException {

        try {
            String startDate = parsedParams.get("/e");
            return DateParser.parseDate(startDate);

        } catch (IndexOutOfBoundsException e) {
            logger.log(Level.WARNING, "I do not understand your date input in end date");
        } catch (NullPointerException e) {
            logger.log(Level.WARNING, "It looks like there is no date input in end date");
        } catch (InvalidDateFormatException e) {
            logger.log(Level.WARNING, "Invalid date in start date");
            throw new InvalidDateFormatException();
        }
        searchResult.append("End date is empty, "
                + "and it is replaced with the latest date.\n\t ");
        return DateParser.parseDate("9999-12-12");
    }

}
