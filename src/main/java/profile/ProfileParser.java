package profile;

import commands.Command;
import commands.profile.AddProfile;
import commands.profile.DeleteProfile;
import commands.profile.EndProfile;
import commands.profile.ViewProfile;
import exceptions.profile.InvalidAgeException;
import exceptions.profile.InvalidCommandFormatException;
import exceptions.profile.InvalidCommandWordException;
import exceptions.profile.InvalidHeightException;
import exceptions.profile.InvalidWeightException;
import exceptions.profile.RedundantParamException;

import java.util.HashMap;

import static profile.Constants.AGE_LOWER_BOUND;
import static profile.Constants.AGE_UPPER_BOUND;
import static profile.Constants.COMMAND_ARGS_INDEX;
import static profile.Constants.COMMAND_SPLIT_LIMIT;
import static profile.Constants.COMMAND_TYPE_INDEX;
import static profile.Constants.COMMAND_WORD_ADD;
import static profile.Constants.COMMAND_WORD_DELETE;
import static profile.Constants.COMMAND_WORD_END;
import static profile.Constants.COMMAND_WORD_VIEW;
import static profile.Constants.EMPTY_STRING;
import static profile.Constants.GREEDY_WHITE_SPACE;
import static profile.Constants.HEIGHT_LOWER_BOUND;
import static profile.Constants.HEIGHT_UPPER_BOUND;
import static profile.Constants.WEIGHT_LOWER_BOUND;
import static profile.Constants.WEIGHT_UPPER_BOUND;

/**
 * A class that deals with making sense of user's command inside Profile Session.
 */
public class ProfileParser {

    /**
     * Parses and returns the Command associated with the user input.
     *
     * @param userInputString User's raw input string.
     * @return Associated command.
     * @throws InvalidCommandWordException If command word is invalid.
     * @throws RedundantParamException If redundant parameters are provided.
     */
    public Command parseCommand(String userInputString) throws InvalidCommandWordException, RedundantParamException {
        String[] commandTypeAndParams = splitCommandWordAndArgs(userInputString);
        String commandType = commandTypeAndParams[COMMAND_TYPE_INDEX].toLowerCase();
        String commandArgs = commandTypeAndParams[COMMAND_ARGS_INDEX];

        switch (commandType) {
        case COMMAND_WORD_ADD:
            return new AddProfile(commandArgs);
        case COMMAND_WORD_DELETE:
            return new DeleteProfile(commandArgs);
        case COMMAND_WORD_VIEW:
            return new ViewProfile(commandArgs);
        case COMMAND_WORD_END:
            return new EndProfile(commandArgs);
        default:
            throw new InvalidCommandWordException();
        }
    }

    /**
     * Splits raw user's input into command word and command arguments string.
     *
     * @param rawUserInput User's raw input.
     * @return Size 2 array; first element is the command type and second element is the arguments string.
     */
    public static String[] splitCommandWordAndArgs(String rawUserInput) {
        String[] split = rawUserInput.trim().split(GREEDY_WHITE_SPACE,
                COMMAND_SPLIT_LIMIT);

        return split.length == COMMAND_SPLIT_LIMIT ? split : new String[]{split[COMMAND_TYPE_INDEX], EMPTY_STRING};
    }

    public static HashMap<String, String> extractCommandTagAndInfo(String commandArgs)
            throws InvalidCommandFormatException {
        if (!commandArgs.contains("/")) {
            throw new InvalidCommandFormatException(COMMAND_WORD_ADD);
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
                String optionIndicator = commandArgs.substring(startIndex, startIndex + 2).trim();
                parsedParams.put(optionIndicator, parsedOption);

                startIndex = endIndex;
            }

            return parsedParams;
        } catch (StringIndexOutOfBoundsException e) {
            throw new InvalidCommandFormatException(COMMAND_WORD_ADD.toLowerCase());
        }
    }

    public static String extractName(HashMap<String, String> parsedParams) {
        return parsedParams.get("/n");
    }

    public static int extractAge(HashMap<String, String> parsedParams) throws InvalidAgeException {
        try {
            int age = Integer.parseInt(parsedParams.get("/a"));

            if (!checkValidAge(age)) {
                throw new InvalidAgeException();
            }
            return age;
        } catch (NumberFormatException e) {
            throw new InvalidAgeException();
        }
    }

    public static int extractHeight(HashMap<String, String> parsedParams) throws InvalidHeightException {
        try {
            int height = Integer.parseInt(parsedParams.get("/h"));

            if (!checkValidHeight(height)) {
                throw new InvalidHeightException();
            }
            return height;
        } catch (NumberFormatException e) {
            throw new InvalidHeightException();
        }
    }

    public static double extractWeight(HashMap<String, String> parsedParams) throws InvalidWeightException {
        try {
            double weight = Double.parseDouble(parsedParams.get("/w"));

            if (!checkValidWeight(weight)) {
                throw new InvalidWeightException();
            }
            return weight;
        } catch (NumberFormatException e) {
            throw new InvalidWeightException();
        }
    }

    public static double extractExpectedWeight(HashMap<String, String> parsedParams) throws InvalidWeightException {
        try {
            double expectedWeight = Double.parseDouble(parsedParams.get("/e"));

            if (!checkValidWeight(expectedWeight)) {
                throw new InvalidWeightException();
            }
            return expectedWeight;
        } catch (NumberFormatException e) {
            throw new InvalidWeightException();
        }
    }

    /**
     * Verifies if user's input when creating profile is valid.
     *
     * @param profile User Profile object.
     * @return Whether input profile is valid.
     */
    public static boolean checkValidProfile(Profile profile) {
        return (checkValidName(profile.getName())
                && checkValidAge(profile.getAge())
                && checkValidHeight(profile.getHeight())
                && checkValidWeight(profile.getWeight())
                && checkValidWeight(profile.getExpectedWeight()));
    }

    /**
     * Verifies if user's input name is not empty string.
     *
     * @param name User's input name.
     * @return Whether input name is valid.
     */
    public static boolean checkValidName(String name) {
        return !name.isEmpty();
    }

    /**
     * Verifies if user's input age is in the valid range
     * (between {@link AGE_LOWER_BOUND} and {@link AGE_UPPER_BOUND} inclusive).
     *
     * @param age User's input age.
     * @return Whether input age is valid.
     */
    public static boolean checkValidAge(int age) {
        return (age >= AGE_LOWER_BOUND && age <= AGE_UPPER_BOUND);
    }

    /**
     * Verifies if user's input height is in the valid range
     * (between {@link HEIGHT_LOWER_BOUND} and {@link HEIGHT_UPPER_BOUND} inclusive).
     *
     * @param height User's input height.
     * @return Whether input height is valid.
     */
    public static boolean checkValidHeight(int height) {
        return (height >= HEIGHT_LOWER_BOUND && height <= HEIGHT_UPPER_BOUND);
    }

    /**
     * Verifies if user's input weight is in the valid range
     * (between {@link WEIGHT_LOWER_BOUND} and {@link WEIGHT_UPPER_BOUND} inclusive).
     *
     * @param weight User's input weight.
     * @return Whether input weight is valid.
     */
    public static boolean checkValidWeight(double weight) {
        return (weight >= WEIGHT_LOWER_BOUND && weight <= WEIGHT_UPPER_BOUND);
    }
}
