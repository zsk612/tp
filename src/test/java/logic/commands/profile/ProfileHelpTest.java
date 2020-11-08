package logic.commands.profile;

import org.junit.jupiter.api.Test;
import storage.profile.ProfileStorage;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static ui.CommonUi.EMPTY_STRING;

//@@author tienkhoa16
class ProfileHelpTest {
    private static final Path SAMPLE_DATA_FOLDER = Paths.get("src", "test", "java", "saves", "ProfileCommandsTest");

    @Test
    void testExecute_inputNullArguments_ValidStorage_throwsAssertionError() {
        Path dataFile = Paths.get(SAMPLE_DATA_FOLDER.toString(), "profileDataFile.json");
        ProfileStorage storage = new ProfileStorage(SAMPLE_DATA_FOLDER, dataFile);
        assertThrows(AssertionError.class, () -> {
            new ProfileHelp().execute(null, storage);
        });
    }

    @Test
    void testExecute_inputEmptyArguments_NullStorage_throwsAssertionError() {
        assertThrows(AssertionError.class, () -> {
            new ProfileHelp().execute(EMPTY_STRING, (ProfileStorage) null);
        });
    }
}
