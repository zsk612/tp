package profile;

import diet.dietsession.DietSession;
import exceptions.EndException;
import exceptions.InsufficientArgumentException;
import exceptions.InvalidCommandWordException;
import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidCommandFormatException;
import logic.commands.CommandResult;
import models.Profile;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import storage.diet.DietStorage;
import storage.profile.ProfileStorage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static profile.Constants.ADD_PROFILE_FORMAT;
import static profile.Constants.EDIT_PROFILE_FORMAT;
import static profile.Constants.EXAMPLE_CALORIES;
import static profile.Constants.EXAMPLE_EXPECTED_WEIGHT;
import static profile.Constants.EXAMPLE_HEIGHT;
import static profile.Constants.EXAMPLE_NAME;
import static profile.Constants.EXAMPLE_WEIGHT;
import static seedu.duke.Constant.COMMAND_WORD_ADD;
import static seedu.duke.Constant.COMMAND_WORD_DELETE;
import static seedu.duke.Constant.COMMAND_WORD_EDIT;
import static seedu.duke.Constant.COMMAND_WORD_END;
import static seedu.duke.Constant.COMMAND_WORD_VIEW;
import static ui.CommonUi.EMPTY_STRING;
import static ui.CommonUi.helpFormatter;
import static ui.profile.ProfileUi.MESSAGE_CREATE_PROFILE_ACK;
import static ui.profile.ProfileUi.MESSAGE_DELETE_PROFILE;
import static ui.profile.ProfileUi.MESSAGE_EDIT_PROFILE_ACK;
import static ui.profile.ProfileUi.MESSAGE_MORE_CALORIES;
import static ui.profile.ProfileUi.MESSAGE_VIEW_PROFILE;

//@@author tienkhoa16
class ProfileSessionTest {
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static final Path SAMPLE_DATA_FOLDER = Paths.get("src", "test", "java", "saves", "ProfileSessionTest");
    private static final Path SAMPLE_DATA_FILE = Paths.get(SAMPLE_DATA_FOLDER.toString(), "profileDataFile.json");

    private static final String TEST_SAVES_FOLDER_DIET = "src/test/java/saves/ProfileSessionTest/diet/";
    private static final String TEST_SAVE_NAME = DTF.format(LocalDate.now()) + " breakfast";

    private static final Profile SAMPLE_PROFILE = new Profile(EXAMPLE_NAME, EXAMPLE_HEIGHT, EXAMPLE_WEIGHT,
            EXAMPLE_EXPECTED_WEIGHT, EXAMPLE_CALORIES);
    private static ProfileSession profileSession = ProfileSession.getInstance(SAMPLE_DATA_FOLDER, SAMPLE_DATA_FILE);

    @Test
    void testProcessCommand_inputNull_throwsAssertionError() {
        assertThrows(AssertionError.class, () -> {
            profileSession.processCommand(null);
        });
    }

    @Test
    void testProcessCommand_inputEmptyString_throwsAssertionError() {
        assertThrows(AssertionError.class, () -> {
            profileSession.processCommand(EMPTY_STRING);
        });
    }

    @Test
    void testProcessCommand_inputWrongCommand_throwsInvalidCommandWordException() {
        String userInput = "wrong command";
        assertThrows(InvalidCommandWordException.class, () -> {
            profileSession.processCommand(userInput);
        });
    }

    @Test
    void testProcessCommand_inputAddProfileString_returnSuccess() {
        assertThrows(AssertionError.class, () -> {
            profileSession.processCommand(EMPTY_STRING);
        });
    }

    @Test
    void testProcessCommand_inputValidAddProfileCommand_returnSuccess() throws SchwarzeneggerException {
        String userInput = "add /n Schwarzenegger /h 188 /w 113 /e 100 /c 2500";
        ProfileStorage storage = new ProfileStorage(SAMPLE_DATA_FOLDER, SAMPLE_DATA_FILE);
        storage.saveData(null);

        String successMsg = String.format(MESSAGE_CREATE_PROFILE_ACK, SAMPLE_PROFILE.toString());
        assertEquals(successMsg, profileSession.processCommand(userInput).getFeedbackMessage());
    }

    @Test
    void testProcessCommand_inputInvalidAddProfileCommand_throwsInsufficientArgumentException()
            throws SchwarzeneggerException {
        String userInput = "add /n Schwarzenegger";
        ProfileStorage storage = new ProfileStorage(SAMPLE_DATA_FOLDER, SAMPLE_DATA_FILE);
        storage.saveData(null);

        assertThrows(InsufficientArgumentException.class, () -> {
            profileSession.processCommand(userInput);
        });
    }

    @Test
    void testProcessCommand_inputValidDeleteProfileCommand_returnSuccess() throws SchwarzeneggerException {
        String userInput = "delete";
        ProfileStorage storage = new ProfileStorage(SAMPLE_DATA_FOLDER, SAMPLE_DATA_FILE);
        storage.saveData(SAMPLE_PROFILE);

        System.setIn(new ByteArrayInputStream("YES".getBytes()));
        CommandResult result = profileSession.processCommand(userInput);
        System.setIn(System.in);

        assertEquals(MESSAGE_DELETE_PROFILE, result.getFeedbackMessage());
    }

    @Test
    void testProcessCommand_inputValidEditProfileCommand_returnSuccess() throws SchwarzeneggerException {
        String userInput = "edit /n Arnold";
        ProfileStorage storage = new ProfileStorage(SAMPLE_DATA_FOLDER, SAMPLE_DATA_FILE);
        storage.saveData(SAMPLE_PROFILE);

        Profile editedProfile = new Profile("Arnold", EXAMPLE_HEIGHT, EXAMPLE_WEIGHT,
                EXAMPLE_EXPECTED_WEIGHT, EXAMPLE_CALORIES);
        String successMsg = String.format(MESSAGE_EDIT_PROFILE_ACK, editedProfile.toString());

        assertEquals(successMsg, profileSession.processCommand(userInput).getFeedbackMessage());
    }

    @Test
    void testProcessCommand_inputInvalidEditProfileCommand_throwsInvalidCommandFormatException()
            throws SchwarzeneggerException {
        String userInput = "edit";
        ProfileStorage storage = new ProfileStorage(SAMPLE_DATA_FOLDER, SAMPLE_DATA_FILE);
        storage.saveData(SAMPLE_PROFILE);

        assertThrows(InvalidCommandFormatException.class, () -> {
            profileSession.processCommand(userInput);
        });
    }

    @Test
    void testProcessCommand_inputValidEndProfileCommand_throwsEndException() {
        String userInput = "end";
        assertThrows(EndException.class, () -> {
            profileSession.processCommand(userInput);
        });
    }

    @Test
    void testProcessCommand_inputValidHelpProfileCommand_returnHelpMessage() throws SchwarzeneggerException {
        StringBuilder helpMessage = new StringBuilder();
        helpMessage.append(helpFormatter(StringUtils.capitalize(COMMAND_WORD_ADD), ADD_PROFILE_FORMAT,
                "Add your new profile"));
        helpMessage.append(helpFormatter(StringUtils.capitalize(COMMAND_WORD_VIEW), COMMAND_WORD_VIEW,
                "View your profile"));
        helpMessage.append(helpFormatter(StringUtils.capitalize(COMMAND_WORD_EDIT), EDIT_PROFILE_FORMAT,
                "Edit your existing profile. You may edit from 1 field to all fields"));
        helpMessage.append(helpFormatter(StringUtils.capitalize(COMMAND_WORD_DELETE), COMMAND_WORD_DELETE,
                "Delete your existing profile"));
        helpMessage.append(helpFormatter(StringUtils.capitalize(COMMAND_WORD_END), COMMAND_WORD_END,
                "Go back to Main Menu"));
        String userInput = "help";
        assertEquals(helpMessage.toString().trim(), profileSession.processCommand(userInput).getFeedbackMessage());
    }

    @Test
    void testProcessCommand_inputValidViewProfileCommand_returnSuccess() throws SchwarzeneggerException,
            IOException {
        ProfileStorage profileStorage = new ProfileStorage(SAMPLE_DATA_FOLDER, SAMPLE_DATA_FILE);
        profileStorage.saveData(SAMPLE_PROFILE);

        DietStorage dietStorage = new DietStorage();
        dietStorage.init(TEST_SAVES_FOLDER_DIET, TEST_SAVE_NAME);
        DietSession savedInstance = new DietSession("breakfast", DTF.format(LocalDate.now()), true, 1);
        savedInstance.saveToFile(TEST_SAVES_FOLDER_DIET, dietStorage, savedInstance);

        String sampleCaloriesMsg = String.format(MESSAGE_MORE_CALORIES, EXAMPLE_CALORIES);

        String userInput = "view";
        assertEquals(String.format(MESSAGE_VIEW_PROFILE, SAMPLE_PROFILE.toString(), sampleCaloriesMsg),
                profileSession.processCommand(userInput).getFeedbackMessage());
    }
}
