package logic.commands.profile;

import exceptions.SchwarzeneggerException;
import logic.commands.CommandResult;
import models.Profile;
import org.junit.jupiter.api.Test;
import storage.profile.ProfileStorage;

import java.io.ByteArrayInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static profile.Constants.EMPTY_STRING;
import static profile.Constants.EXAMPLE_CALORIES;
import static profile.Constants.EXAMPLE_EXPECTED_WEIGHT;
import static profile.Constants.EXAMPLE_HEIGHT;
import static profile.Constants.EXAMPLE_NAME;
import static profile.Constants.EXAMPLE_WEIGHT;
import static ui.profile.ProfileUi.MESSAGE_DELETE_NOTHING;
import static ui.profile.ProfileUi.MESSAGE_DELETE_PROFILE;
import static ui.workout.workoutmanager.WorkoutManagerUi.CLEAR_ABORTED;

class ProfileDeleteTest {
    private static final Path SAMPLE_DATA_FOLDER = Paths.get("src", "test", "java", "saves", "ProfileCommandsTest");
    private static final Profile SAMPLE_PROFILE = new Profile(EXAMPLE_NAME, EXAMPLE_HEIGHT, EXAMPLE_WEIGHT,
            EXAMPLE_EXPECTED_WEIGHT, EXAMPLE_CALORIES);

    @Test
    void testExecute_inputNullArguments_NullStorage_throwsAssertionError() {
        assertThrows(AssertionError.class, () -> {
            new ProfileAdd().execute(null, (ProfileStorage) null);
        });
    }

    @Test
    void testExecute_hasExistingProfile_inputYes_returnSuccess() throws SchwarzeneggerException {
        Path dataFile = Paths.get(SAMPLE_DATA_FOLDER.toString(), "dataFile.json");
        ProfileStorage storage = new ProfileStorage(SAMPLE_DATA_FOLDER, dataFile);
        storage.saveData(SAMPLE_PROFILE);

        System.setIn(new ByteArrayInputStream("YES".getBytes()));
        CommandResult result = new ProfileDelete().execute(EMPTY_STRING, storage);
        System.setIn(System.in);

        assertEquals(MESSAGE_DELETE_PROFILE, result.getFeedbackMessage());
    }

    @Test
    void testExecute_hasExistingProfile_inputDifferentFromYes_returnFailure() throws SchwarzeneggerException {
        Path dataFile = Paths.get(SAMPLE_DATA_FOLDER.toString(), "dataFile.json");
        ProfileStorage storage = new ProfileStorage(SAMPLE_DATA_FOLDER, dataFile);
        storage.saveData(SAMPLE_PROFILE);

        System.setIn(new ByteArrayInputStream("some input different from YES".getBytes()));
        CommandResult result = new ProfileDelete().execute(EMPTY_STRING, storage);
        System.setIn(System.in);

        assertEquals(CLEAR_ABORTED, result.getFeedbackMessage());
    }

    @Test
    void testExecute_noExistingProfile_returnFailure() throws SchwarzeneggerException {
        Path dataFile = Paths.get(SAMPLE_DATA_FOLDER.toString(), "dataFile.json");
        ProfileStorage storage = new ProfileStorage(SAMPLE_DATA_FOLDER, dataFile);
        storage.saveData(null);

        assertEquals(MESSAGE_DELETE_NOTHING, new ProfileDelete().execute(EMPTY_STRING, storage).getFeedbackMessage());
    }
}
