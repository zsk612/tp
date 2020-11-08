package logic.commands.profile;

import exceptions.SchwarzeneggerException;
import models.Profile;
import org.junit.jupiter.api.Test;
import storage.profile.ProfileStorage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static profile.Constants.EMPTY_STRING;
import static profile.Constants.EXAMPLE_CALORIES;
import static profile.Constants.EXAMPLE_EXPECTED_WEIGHT;
import static profile.Constants.EXAMPLE_HEIGHT;
import static profile.Constants.EXAMPLE_NAME;
import static profile.Constants.EXAMPLE_WEIGHT;
import static seedu.duke.Constant.COMMAND_WORD_VIEW;
import static ui.profile.ProfileUi.MESSAGE_ENOUGH_CALORIES;
import static ui.profile.ProfileUi.MESSAGE_MORE_CALORIES;
import static ui.profile.ProfileUi.MESSAGE_PROFILE_NOT_EXIST;
import static ui.profile.ProfileUi.MESSAGE_VIEW_PROFILE;

class ProfileViewTest {
    private static final String SAMPLE_DIET_DATA_FOLDER = Paths.get("src", "test", "java", "saves",
            "ProfileCommandsTest", "diet").toString() + "/";
    private static final Path SAMPLE_PROFILE_DATA_FOLDER = Paths.get("src", "test", "java", "saves",
            "ProfileCommandsTest");
    private static final Profile SAMPLE_PROFILE = new Profile(EXAMPLE_NAME, EXAMPLE_HEIGHT, EXAMPLE_WEIGHT,
            EXAMPLE_EXPECTED_WEIGHT, EXAMPLE_CALORIES);

    @Test
    void testExecute_inputNullArguments_ValidStorage_throwsAssertionError() {
        Path dataFile = Paths.get(SAMPLE_PROFILE_DATA_FOLDER.toString(), "profileDataFile.json");
        ProfileStorage storage = new ProfileStorage(SAMPLE_PROFILE_DATA_FOLDER, dataFile);
        assertThrows(AssertionError.class, () -> {
            new ProfileView().execute(null, storage);
        });
    }

    @Test
    void testExecute_inputEmptyArguments_NullStorage_throwsAssertionError() {
        assertThrows(AssertionError.class, () -> {
            new ProfileView().execute(EMPTY_STRING, (ProfileStorage) null);
        });
    }

    @Test
    void testExecute_noExistingProfile_inputEmptyArguments_ValidStorage_returnFailure() throws SchwarzeneggerException {
        Path dataFile = Paths.get(SAMPLE_PROFILE_DATA_FOLDER.toString(), "profileDataFile.json");
        ProfileStorage storage = new ProfileStorage(SAMPLE_PROFILE_DATA_FOLDER, dataFile);
        storage.saveData(null);

        assertEquals(String.format(MESSAGE_PROFILE_NOT_EXIST, COMMAND_WORD_VIEW),
                new ProfileView().execute(EMPTY_STRING, storage).getFeedbackMessage());
    }

    @Test
    void testExecute_hasExistingProfile_notReachedTarget_inputEmptyArguments_ValidStorage_returnSuccess()
            throws SchwarzeneggerException {
        Path profileDataFile = Paths.get(SAMPLE_PROFILE_DATA_FOLDER.toString(), "profileDataFile.json");
        ProfileStorage storage = new ProfileStorage(SAMPLE_PROFILE_DATA_FOLDER, profileDataFile);
        storage.saveData(SAMPLE_PROFILE);
        String sampleCaloriesMsg = String.format(MESSAGE_MORE_CALORIES, 2200.0);

        assertEquals(String.format(MESSAGE_VIEW_PROFILE, SAMPLE_PROFILE.toString(), sampleCaloriesMsg),
                new ProfileView(SAMPLE_DIET_DATA_FOLDER, LocalDate.of(2020, 11, 8))
                        .execute(EMPTY_STRING, storage).getFeedbackMessage());
    }

    @Test
    void testExecute_hasExistingProfile_reachedTarget_inputEmptyArguments_ValidStorage_returnSuccess()
            throws SchwarzeneggerException {
        Path profileDataFile = Paths.get(SAMPLE_PROFILE_DATA_FOLDER.toString(), "profileDataFile.json");
        ProfileStorage storage = new ProfileStorage(SAMPLE_PROFILE_DATA_FOLDER, profileDataFile);
        storage.saveData(SAMPLE_PROFILE);
        String sampleCaloriesMsg = MESSAGE_ENOUGH_CALORIES;

        assertEquals(String.format(MESSAGE_VIEW_PROFILE, SAMPLE_PROFILE.toString(), sampleCaloriesMsg),
                new ProfileView(SAMPLE_DIET_DATA_FOLDER, LocalDate.of(2020, 11, 7))
                        .execute(EMPTY_STRING, storage).getFeedbackMessage());
    }
}
