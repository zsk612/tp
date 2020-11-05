package logic.parser;

import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidCaloriesException;
import exceptions.profile.InvalidCommandFormatException;
import exceptions.profile.InvalidHeightException;
import exceptions.profile.InvalidNameException;
import exceptions.profile.InvalidWeightException;
import exceptions.workout.workoutmanager.InsufficientArgumentException;
import org.apache.commons.lang3.text.WordUtils;
import profile.Utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static profile.Constants.ADD_PROFILE_FORMAT;
import static profile.Constants.EDIT_PROFILE_FORMAT;
import static seedu.duke.Constant.COMMAND_WORD_ADD;
import static seedu.duke.Constant.COMMAND_WORD_EDIT;
import static seedu.duke.Constant.COMMAND_WORD_HELP;

/**
 * A class that deals with making sense of user's command inside Profile Session.
 */
public class ProfileParser extends CommonParser {

    /**
     * Extracts command tags from user input to get option indicator and parsed option.
     *
     * @param command Command being executed.
     * @param commandArgs User's input arguments.
     * @return HashMap containing option indicator and parsed option pairs.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    public static HashMap<String, String> extractCommandTagAndInfo(String command, String commandArgs)
            throws SchwarzeneggerException {
        if (!commandArgs.contains("/")) {
            throwInvalidCommandFormat(command);
        }

        HashMap<String, String> parsedParams = new HashMap<>();
        int startIndex = 0;
        int endIndex = 0;

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

            if (!checkSufficientParams(command, parsedParams)) {
                throwInsufficientArgument(command);
            }
        } catch (StringIndexOutOfBoundsException e) {
            throwInvalidCommandFormat(command);
        }

        return parsedParams;
    }

    /**
     * Checks if user inputs sufficient number of params to the command.
     *
     * @param command Type of command being executed.
     * @param parsedParams HashMap containing option indicator and parsed option pairs.
     * @return If the number of params input to the command is sufficient.
     */
    private static boolean checkSufficientParams(String command, HashMap<String, String> parsedParams) {
        boolean isSufficient = true;

        switch (command) {
        case COMMAND_WORD_ADD:
            if (!parsedParams.containsKey("/n") || !parsedParams.containsKey("/h") || !parsedParams.containsKey("/w")
                    || !parsedParams.containsKey("/e") || !parsedParams.containsKey("/c")) {
                isSufficient = false;
            }
            break;
        case COMMAND_WORD_EDIT:
            if (!(parsedParams.containsKey("/n") || parsedParams.containsKey("/h") || parsedParams.containsKey("/w")
                    || parsedParams.containsKey("/e") || parsedParams.containsKey("/c"))) {
                isSufficient = false;
            }
            break;
        default:
            isSufficient = true;
            break;
        }
        return isSufficient;
    }

    /**
     * Finds invalid tags (option indicators) in user's input.
     *
     * @param parsedParams HashMap containing option indicator and parsed option pairs.
     * @return String containing invalid tags.
     */
    public static String findInvalidTags(HashMap<String, String> parsedParams) {
        StringBuilder result = new StringBuilder();

        Set<String> validTags = new HashSet<>(Arrays.asList("/n", "/h", "/w", "/e", "/c"));
        parsedParams.keySet().stream()
                .filter(tag -> !validTags.contains(tag))
                .forEach(tag -> result.append(String.format("\"%s\", ", tag)));

        String trimmedResult = result.toString().trim();
        return trimmedResult.isEmpty() ? trimmedResult : trimmedResult.substring(0, trimmedResult.length() - 1);
    }

    /**
     * Throws InsufficientArgumentException with the correct param based on the command.
     *
     * @param command Command with invalid format.
     * @throws InsufficientArgumentException If command has invalid format.
     */
    private static void throwInsufficientArgument(String command)
            throws InsufficientArgumentException {
        if (command.equals(COMMAND_WORD_ADD)) {
            throw new InsufficientArgumentException(ADD_PROFILE_FORMAT);
        } else if (command.equals(COMMAND_WORD_EDIT)) {
            throw new InsufficientArgumentException(EDIT_PROFILE_FORMAT);
        } else {
            throw new InsufficientArgumentException(COMMAND_WORD_HELP);
        }
    }

    /**
     * Throws InvalidCommandFormatException with the correct param based on the command.
     *
     * @param command Command with invalid format.
     * @throws InvalidCommandFormatException If command has invalid format.
     */
    private static void throwInvalidCommandFormat(String command) throws InvalidCommandFormatException {
        if (command.equals(COMMAND_WORD_ADD)) {
            throw new InvalidCommandFormatException(ADD_PROFILE_FORMAT);
        } else if (command.equals(COMMAND_WORD_EDIT)) {
            throw new InvalidCommandFormatException(EDIT_PROFILE_FORMAT);
        } else {
            throw new InvalidCommandFormatException(COMMAND_WORD_HELP);
        }
    }

    /**
     * Extracts name from parsed HashMap.
     *
     * @param parsedParams HashMap containing option indicator and parsed option pairs.
     * @return User's name.
     * @throws InvalidNameException If input name is empty.
     */
    public static String extractName(HashMap<String, String> parsedParams) throws InvalidNameException {
        String name = WordUtils.capitalizeFully(parsedParams.get("/n"));

        if (!Utils.checkValidName(name)) {
            throw new InvalidNameException();
        }

        return name;
    }

    /**
     * Extracts calories from parsed HashMap.
     *
     * @param parsedParams HashMap containing option indicator and parsed option pairs.
     * @return User's calories.
     * @throws InvalidCaloriesException If input calories amount is invalid.
     */
    public static double extractCalories(HashMap<String, String> parsedParams) throws InvalidCaloriesException {
        try {
            double calories = Double.parseDouble(parsedParams.get("/c"));

            if (!Utils.checkValidCalories(calories)) {
                throw new InvalidCaloriesException();
            }
            return calories;
        } catch (NumberFormatException | NullPointerException e) {
            throw new InvalidCaloriesException();
        }
    }

    /**
     * Extracts height from parsed HashMap.
     *
     * @param parsedParams HashMap containing option indicator and parsed option pairs.
     * @return User's height.
     * @throws InvalidHeightException If input height is invalid.
     */
    public static int extractHeight(HashMap<String, String> parsedParams) throws InvalidHeightException {
        try {
            int height = Integer.parseInt(parsedParams.get("/h"));

            if (!Utils.checkValidHeight(height)) {
                throw new InvalidHeightException();
            }
            return height;
        } catch (NumberFormatException e) {
            throw new InvalidHeightException();
        }
    }

    /**
     * Extracts weight from parsed HashMap.
     *
     * @param parsedParams HashMap containing option indicator and parsed option pairs.
     * @return User's weight.
     * @throws InvalidWeightException If input weight is invalid.
     */
    public static double extractWeight(HashMap<String, String> parsedParams) throws InvalidWeightException {
        try {
            double weight = Double.parseDouble(parsedParams.get("/w"));

            if (!Utils.checkValidWeight(weight)) {
                throw new InvalidWeightException();
            }
            return weight;
        } catch (NumberFormatException | NullPointerException e) {
            throw new InvalidWeightException();
        }
    }

    /**
     * Extracts expected weight from parsed HashMap.
     *
     * @param parsedParams HashMap containing option indicator and parsed option pairs.
     * @return User's expected weight.
     * @throws InvalidWeightException If input expected weight is invalid.
     */
    public static double extractExpectedWeight(HashMap<String, String> parsedParams) throws InvalidWeightException {
        try {
            double expectedWeight = Double.parseDouble(parsedParams.get("/e"));

            if (!Utils.checkValidWeight(expectedWeight)) {
                throw new InvalidWeightException();
            }
            return expectedWeight;
        } catch (NumberFormatException | NullPointerException e) {
            throw new InvalidWeightException();
        }
    }
}
