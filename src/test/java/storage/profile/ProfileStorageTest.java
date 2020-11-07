package storage.profile;

import exceptions.SchwarzeneggerException;
import exceptions.profile.InvalidSaveFormatException;
import models.Profile;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static profile.Constants.EXAMPLE_CALORIES;
import static profile.Constants.EXAMPLE_EXPECTED_WEIGHT;
import static profile.Constants.EXAMPLE_HEIGHT;
import static profile.Constants.EXAMPLE_NAME;
import static profile.Constants.EXAMPLE_WEIGHT;

//@@author tienkhoa16
class ProfileStorageTest {
    private static final String TEST_SAVES_FOLDER = Paths.get("src", "test", "java", "saves", "ProfileStorageTest")
            .toString();

    @Test
    void testDecodeProfile_exampleProfileData_returnsExampleProfileString() throws SchwarzeneggerException,
            FileNotFoundException {
        ProfileStorage storage = new ProfileStorage();
        String inputFilePath = Paths.get(TEST_SAVES_FOLDER, "exampleProfileData.json").toString();
        Profile testProfile = storage.decodeProfile(inputFilePath);
        Profile exampleProfile = new Profile(
                EXAMPLE_NAME, EXAMPLE_HEIGHT, EXAMPLE_WEIGHT, EXAMPLE_EXPECTED_WEIGHT, EXAMPLE_CALORIES);
        assertEquals(exampleProfile, testProfile);
    }

    @Test
    void testDecodeProfile_corruptedDataInput_throwsInvalidSaveFormatException() {
        ProfileStorage storage = new ProfileStorage();
        String inputFilePath = Paths.get(TEST_SAVES_FOLDER, "corruptedProfileData.json").toString();
        assertThrows(InvalidSaveFormatException.class, () -> {
            storage.decodeProfile(inputFilePath);
        });
    }

    @Test
    void testDecodeProfile_invalidDataInput_throwsInvalidSaveFormatException() {
        ProfileStorage storage = new ProfileStorage();
        String inputFilePath = Paths.get(TEST_SAVES_FOLDER, "invalidProfileData.json").toString();
        assertThrows(InvalidSaveFormatException.class, () -> {
            storage.decodeProfile(inputFilePath);
        });
    }
}
