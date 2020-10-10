package profile;

import org.junit.jupiter.api.Test;
import profile.components.Profile;
import profile.exceptions.InvalidSaveFormatException;
import profile.exceptions.SchwarzeneggerException;
import profile.storage.Storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static profile.components.Constants.EXAMPLE_PROFILE_DATA;
import static profile.components.Constants.EXAMPLE_PROFILE_STRING;

class ProfileTest {

    /**
     * Tests decodeProfile method of class Storage when data from file is valid.
     *
     * @throws SchwarzeneggerException If there are exceptions while decoding data.
     */
    @Test
    void testDecodeProfile_exampleDataInput_returnsExampleProfileString() throws SchwarzeneggerException {
        Storage storage = new Storage();
        Profile testProfile = storage.decodeProfile(EXAMPLE_PROFILE_DATA);
        assertEquals(EXAMPLE_PROFILE_STRING, testProfile.toString());
    }

    @Test
    void testDecodeProfile_invalidDataInput_throwsInvalidSaveFormatException() {
        Storage storage = new Storage();
        assertThrows(InvalidSaveFormatException.class, () -> {
            storage.decodeProfile("Schwarzenegger");
        });
    }
}
