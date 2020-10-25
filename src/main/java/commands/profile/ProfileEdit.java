package commands.profile;

import commands.Command;
import commands.CommandResult;
import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidSaveFormatException;
import profile.Profile;
import storage.profile.ProfileStorage;

import java.util.HashMap;

import static commands.ExecutionResult.FAILED;
import static commands.ExecutionResult.OK;
import static commands.ExecutionResult.SKIPPED;
import static profile.Constants.MESSAGE_EDIT_NOTHING;
import static profile.Constants.MESSAGE_EDIT_PROFILE_ACK;
import static profile.Constants.MESSAGE_PROFILE_NOT_EXIST;
import static profile.ProfileParser.extractAge;
import static profile.ProfileParser.extractCommandTagAndInfo;
import static profile.ProfileParser.extractExpectedWeight;
import static profile.ProfileParser.extractHeight;
import static profile.ProfileParser.extractName;
import static profile.ProfileParser.extractWeight;
import static seedu.duke.Constant.COMMAND_WORD_EDIT;

/**
 * A representation of the command for editing profile.
 */
public class ProfileEdit extends Command {

    /**
     * Overrides execute method of class Command to execute the edit profile command requested by user's input.
     *
     * @param commandArgs User's input arguments.
     * @param storage Profile Storage to load and save data.
     * @return Result of command execution.
     * @throws SchwarzeneggerException If there are caught exceptions.
     */
    @Override
    public CommandResult execute(String commandArgs, ProfileStorage storage) throws SchwarzeneggerException {
        super.execute(commandArgs, storage);

        Profile profile;
        try {
            profile = storage.loadData();

            HashMap<String, String> parsedParams = extractCommandTagAndInfo(COMMAND_WORD_EDIT, commandArgs);
            String name = parsedParams.containsKey("/n") ? extractName(parsedParams) : profile.getName();
            int age = parsedParams.containsKey("/a") ? extractAge(parsedParams) : profile.getAge();
            int height = parsedParams.containsKey("/h") ? extractHeight(parsedParams) : profile.getHeight();
            double weight = parsedParams.containsKey("/w") ? extractWeight(parsedParams) : profile.getWeight();
            double expectedWeight = parsedParams.containsKey("/e")
                    ? extractExpectedWeight(parsedParams) : profile.getExpectedWeight();

            Profile editedProfile = new Profile(name, age, height, weight, expectedWeight);

            if (profile.equals(editedProfile)) {
                return new CommandResult(MESSAGE_EDIT_NOTHING, SKIPPED);
            }

            storage.saveData(editedProfile);

            return new CommandResult(String.format(MESSAGE_EDIT_PROFILE_ACK, profile.toString()), OK);
        } catch (InvalidSaveFormatException e) {
            return new CommandResult(String.format(MESSAGE_PROFILE_NOT_EXIST, COMMAND_WORD_EDIT), FAILED);
        }
    }
}
