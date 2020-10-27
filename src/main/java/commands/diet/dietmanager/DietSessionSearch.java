package commands.diet.dietmanager;

import commands.Command;
import diet.DateParser;
import diet.dietmanager.DietManagerParser;
import exceptions.InvalidDateFormatException;
import exceptions.diet.InvalidSearchDateException;
import exceptions.profile.InvalidCommandFormatException;
import storage.diet.DietStorage;
import ui.diet.dietmanager.DietManagerUi;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Level;

import static seedu.duke.Constant.COMMAND_WORD_SEARCH;

public class DietSessionSearch extends Command {

    static final String FILEPATH = "saves/diet/";

    private final DietManagerParser parser = new DietManagerParser();

    /**
     * Overrides execute for search command to search diet sessions.
     *
     * @param input user input for search command
     * @param storage storage file
     * @throws InvalidDateFormatException if the date is in wrong format
     * @throws InvalidSearchDateException if the starting date is later than end date
     */
    public void execute(String input, DietStorage storage) throws InvalidDateFormatException,
            InvalidSearchDateException {


        File folder = new File(FILEPATH);
        File[] listOfFiles = folder.listFiles();
        assert folder.exists();
        StringBuilder searchResult = new StringBuilder();
        try {
            HashMap<String, String> parsedParams = parser.extractDietManagerCommandTagAndInfo(COMMAND_WORD_SEARCH,
                    input);
            LocalDateTime startDate = parser.extractStartDates(parsedParams, searchResult);
            LocalDateTime endDate = parser.extractEndDates(parsedParams, searchResult);
            if (startDate.compareTo(endDate) > 0) {
                throw new InvalidSearchDateException("Starting date should be earlier than end date.");
            }
            String tag = parser.extractSearchTag(parsedParams, searchResult);
            printSearchResult(listOfFiles, searchResult, startDate, endDate, tag);

        } catch (NullPointerException | InvalidCommandFormatException e) {
            ui.showToUser("Wrong format, please enter in the format:\n\t "
                    + "search </s [STARTING_DATE]> </e [END_DATE]> </t [TAG]>");
        } catch (InvalidDateFormatException e) {
            searchResult.append("Wrong format for date input.\n\t ");
            ui.showToUser(searchResult.toString().trim());
            logger.log(Level.WARNING, "Invalid date format in diet session search");
            throw new InvalidDateFormatException();
        } catch (InvalidSearchDateException e) {
            logger.log(Level.WARNING, "Invalid date format in diet session search");
            throw new InvalidSearchDateException("Starting date should be earlier than end date.");
        }
    }

    /**
     * Prints search results.
     *
     * @param listOfFiles list of files from local storage
     * @param searchResult string builder that accumulates warning messages
     * @param startDate starting date for search
     * @param endDate end date for search
     * @param tag tag for search
     * @throws InvalidDateFormatException if date is in wrong format
     */
    private void printSearchResult(File[] listOfFiles, StringBuilder searchResult, LocalDateTime startDate,
                                   LocalDateTime endDate, String tag) throws InvalidDateFormatException {
        try {
            if (tag.isEmpty()) {
                searchResult.append("Tag is empty, "
                        + "all the sessions within input dates will be shown.\n\t ");
            }
            searchResult.append("Here are the search results!\n\t ");
            if (Objects.requireNonNull(listOfFiles).length == 0) {
                searchResult.append("It seems like you do not have any meal sessions stored!\n\t ");
            }
            int numberOfResults = 0;
            for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; i++) {
                LocalDateTime fileDate = DateParser.parseDate(listOfFiles[i].getName().split(" ", 2)[0]);
                String fileTag = listOfFiles[i].getName().split(" ", 2)[1];
                if (startDate.compareTo(fileDate) <= 0 && endDate.compareTo(fileDate) >= 0 && fileTag.contains(tag)) {
                    searchResult.append("\t" + (++numberOfResults) + ". "
                            + listOfFiles[i].getName().replaceFirst("[.][^.]+$", "") + "\n\t ");
                }
            }
            if (numberOfResults == 0) {
                searchResult.append("Sorry! There seems to be no diet sessions found with your searched tag.");
            }
            ui.showToUser(searchResult.toString().trim());
            logger.log(Level.INFO, "Listed all searched diet sessions");
        } catch (NullPointerException e) {
            ui.showToUser("Sorry! It seems like you have no meal sessions saved!.");
            logger.log(Level.WARNING, "No instances of diet sessions saved");
        }
    }
}
