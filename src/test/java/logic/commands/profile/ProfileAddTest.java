package logic.commands.profile;

import exceptions.SchwarzeneggerException;
import models.Profile;
import org.junit.jupiter.api.Test;
import storage.profile.ProfileStorage;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static profile.Constants.EXAMPLE_CALORIES;
import static profile.Constants.EXAMPLE_EXPECTED_WEIGHT;
import static profile.Constants.EXAMPLE_HEIGHT;
import static profile.Constants.EXAMPLE_NAME;
import static profile.Constants.EXAMPLE_WEIGHT;
import static ui.profile.ProfileUi.MESSAGE_CREATE_PROFILE_ACK;
import static ui.profile.ProfileUi.MESSAGE_PROFILE_EXIST;

class ProfileAddTest {
    private static final Path SAMPLE_DATA_FOLDER = Paths.get("src", "test", "java", "saves", "ProfileAddTest");
    private static final Profile SAMPLE_PROFILE = new Profile(EXAMPLE_NAME, EXAMPLE_HEIGHT, EXAMPLE_WEIGHT,
            EXAMPLE_EXPECTED_WEIGHT, EXAMPLE_CALORIES);

    @Test
    void testExecute_inputValidArguments_noExistingProfile_returnSuccess() throws SchwarzeneggerException {
        String commandArgs = "/n Schwarzenegger /h 188 /w 113 /e 100 /c 2500";
        Path dataFile = Paths.get(SAMPLE_DATA_FOLDER.toString(), "dataFile.json");
        ProfileStorage storage = new ProfileStorage(SAMPLE_DATA_FOLDER, dataFile);
        storage.saveData(null);

        String successMsg = String.format(MESSAGE_CREATE_PROFILE_ACK, SAMPLE_PROFILE.toString());
        assertEquals(successMsg, new ProfileAdd().execute(commandArgs, storage).getFeedbackMessage());
    }

    @Test
    void testExecute_inputValidArguments_hasExistingProfile_returnSuccess() throws SchwarzeneggerException {
        String commandArgs = "/n Schwarzenegger /h 188 /w 113 /e 100 /c 2500";
        Path dataFile = Paths.get(SAMPLE_DATA_FOLDER.toString(), "dataFile.json");
        ProfileStorage storage = new ProfileStorage(SAMPLE_DATA_FOLDER, dataFile);
        storage.saveData(SAMPLE_PROFILE);

        assertEquals(MESSAGE_PROFILE_EXIST, new ProfileAdd().execute(commandArgs, storage).getFeedbackMessage());
    }

    @Test
    void testExecute_inputNullArguments_NullStorage_throwsAssertionError() {
        assertThrows(AssertionError.class, () -> {
            new ProfileAdd().execute(null, (ProfileStorage) null);
        });
    }
}
