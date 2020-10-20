package commands.profile;

import commands.Command;
import commands.CommandResult;
import commands.ExecutionResult;
import exceptions.profile.InvalidAgeException;
import exceptions.profile.InvalidCommandFormatException;
import exceptions.profile.InvalidHeightException;
import exceptions.profile.InvalidWeightException;
import profile.Profile;

import java.util.HashMap;
import java.util.logging.Level;

import static commands.ExecutionResult.FAILED;
import static commands.ExecutionResult.OK;
import static commands.ExecutionResult.SKIPPED;
import static logger.SchwarzeneggerLogger.logger;
import static profile.Constants.COMMAND_WORD_EDIT;
import static profile.Constants.MESSAGE_EDIT_PROFILE_ACK;
import static profile.Constants.MESSAGE_PROFILE_NOT_EXIST;
import static profile.ProfileParser.extractAge;
import static profile.ProfileParser.extractCommandTagAndInfo;
import static profile.ProfileParser.extractExpectedWeight;
import static profile.ProfileParser.extractHeight;
import static profile.ProfileParser.extractName;
import static profile.ProfileParser.extractWeight;

/**
 * A representation of the command for editing profile.
 */
public class EditProfile extends Command {
    private String commandArgs;
    private ExecutionResult executionResult;

    /**
     * Constructs EditProfile object inheriting abstract class Command.
     *
     * @param commandArgs Command arguments from user's input.
     */
    public EditProfile(String commandArgs) {
        this.commandArgs = commandArgs;
        executionResult = SKIPPED;
    }

    /**
     * Overrides execute method of class Command to execute the edit profile command requested by user's input.
     *
     * @param profile User's Profile object.
     * @return Result of command execution.
     */
    @Override
    public Profile execute(Profile profile) throws InvalidCommandFormatException, InvalidAgeException,
            InvalidHeightException, InvalidWeightException {

        logger.log(Level.INFO, "executing Edit Command");

        if (profile == null) {
            executionResult = FAILED;
            return null;
        }

        HashMap<String, String> parsedParams = extractCommandTagAndInfo(COMMAND_WORD_EDIT, commandArgs);

        String name = parsedParams.containsKey("/n") ? extractName(parsedParams) : profile.getName();
        int age = parsedParams.containsKey("/a") ? extractAge(parsedParams) : profile.getAge();
        int height = parsedParams.containsKey("/h") ? extractHeight(parsedParams) : profile.getHeight();
        double weight = parsedParams.containsKey("/w") ? extractWeight(parsedParams) : profile.getWeight();
        double expectedWeight = parsedParams.containsKey("/e")
                ? extractExpectedWeight(parsedParams) : profile.getExpectedWeight();

        profile = new Profile(name, age, height, weight, expectedWeight);

        executionResult = OK;

        return profile;
    }

    /**
     * Overrides getExecutionResult method of class Command to get execution result after executing edit command.
     *
     * @param profile User's profile.
     * @return Execution result.
     */
    @Override
    public CommandResult getExecutionResult(Profile profile) {
        CommandResult result = null;

        if (executionResult == OK) {
            result = new CommandResult(String.format(MESSAGE_EDIT_PROFILE_ACK, profile.toString()));
        } else if (executionResult == FAILED) {
            result = new CommandResult(String.format(MESSAGE_PROFILE_NOT_EXIST, COMMAND_WORD_EDIT));
        }

        assert (result != null) : "errors in setting execution flag";

        return result;
    }
}
