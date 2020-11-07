package storage.profile;

import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidSaveFormatException;
import org.junit.jupiter.api.Test;
import models.Profile;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static profile.Constants.EXAMPLE_CALORIES;
import static profile.Constants.EXAMPLE_EXPECTED_WEIGHT;
import static profile.Constants.EXAMPLE_HEIGHT;
import static profile.Constants.EXAMPLE_NAME;
import static profile.Constants.EXAMPLE_PROFILE_STRING;
import static profile.Constants.EXAMPLE_WEIGHT;

//@@author tienkhoa16
class ProfileStorageTest {

    /**
     * Tests decodeProfile method of class Storage when data from file is valid.
     *
     * @throws SchwarzeneggerException If there are exceptions while decoding data.
     */
    @Test
    void testDecodeProfile_exampleProfileData_returnsExampleProfileString() throws SchwarzeneggerException,
            FileNotFoundException {
        ProfileStorage storage = new ProfileStorage();
        String inputFilePath = "src/test/java/storage/profile/exampleProfileData.json";
        Profile testProfile = storage.decodeProfile(inputFilePath);
        assertEquals(EXAMPLE_PROFILE_STRING, testProfile.toString());
    }

    /**
     * Tests decodeProfile method of class Storage when data from file is invalid.
     */
    @Test
    void testDecodeProfile_invalidDataInput_throwsInvalidSaveFormatException() {
        ProfileStorage storage = new ProfileStorage();
        String inputFilePath = "src/test/java/storage/profile/invalidProfileData.json";
        assertThrows(InvalidSaveFormatException.class, () -> {
            storage.decodeProfile(inputFilePath);
        });
    }
}
