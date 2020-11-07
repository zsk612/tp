package storage.profile;

import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidSaveFormatException;
import models.Profile;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static profile.Constants.EXAMPLE_PROFILE_STRING;

//@@author tienkhoa16
class ProfileStorageTest {
    private static final String TEST_SAVES_FOLDER = Paths.get("src", "test", "java", "saves", "ProfileStorageTest")
            .toString();

    /**
     * Tests decodeProfile method of class Storage when data from file is valid.
     *
     * @throws SchwarzeneggerException If there are exceptions while decoding data.
     */
    @Test
    void testDecodeProfile_exampleProfileData_returnsExampleProfileString() throws SchwarzeneggerException,
            FileNotFoundException {
        ProfileStorage storage = new ProfileStorage();
        String inputFilePath = Paths.get(TEST_SAVES_FOLDER, "exampleProfileData.json").toString();
        Profile testProfile = storage.decodeProfile(inputFilePath);
        assertEquals(EXAMPLE_PROFILE_STRING, testProfile.toString());
    }

    /**
     * Tests decodeProfile method of class Storage when data from file is invalid.
     */
    @Test
    void testDecodeProfile_invalidDataInput_throwsInvalidSaveFormatException() {
        ProfileStorage storage = new ProfileStorage();
        String inputFilePath = Paths.get(TEST_SAVES_FOLDER, "invalidProfileData.json").toString();
        assertThrows(InvalidSaveFormatException.class, () -> {
            storage.decodeProfile(inputFilePath);
        });
    }
}
