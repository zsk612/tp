package profile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static profile.Constants.AGE_LOWER_BOUND;
import static profile.Constants.AGE_UPPER_BOUND;
import static profile.Constants.EXAMPLE_AGE;
import static profile.Constants.EXAMPLE_EXPECTED_WEIGHT;
import static profile.Constants.EXAMPLE_HEIGHT;
import static profile.Constants.EXAMPLE_NAME;
import static profile.Constants.EXAMPLE_WEIGHT;
import static profile.Constants.HEIGHT_LOWER_BOUND;
import static profile.Constants.HEIGHT_UPPER_BOUND;
import static profile.Constants.WEIGHT_LOWER_BOUND;
import static profile.Constants.WEIGHT_UPPER_BOUND;
import static profile.Utils.checkValidProfile;

class UtilsTest {

    @Test
    void testCheckValidProfile_validProfile_returnTrue() {
        Profile validProfile = new Profile(EXAMPLE_NAME, EXAMPLE_AGE, EXAMPLE_HEIGHT, EXAMPLE_WEIGHT,
                EXAMPLE_EXPECTED_WEIGHT);
        assertTrue(checkValidProfile(validProfile));
    }

    @Test
    void testCheckValidProfile_ageLessThanLowerBound_returnFalse() {
        Profile inValidProfile = new Profile(EXAMPLE_NAME, AGE_LOWER_BOUND - 1, EXAMPLE_HEIGHT, EXAMPLE_WEIGHT,
                EXAMPLE_EXPECTED_WEIGHT);
        assertFalse(checkValidProfile(inValidProfile));
    }

    @Test
    void testCheckValidProfile_ageGreaterThanUpperBound_returnFalse() {
        Profile inValidProfile = new Profile(EXAMPLE_NAME, AGE_UPPER_BOUND + 1, EXAMPLE_HEIGHT, EXAMPLE_WEIGHT,
                EXAMPLE_EXPECTED_WEIGHT);
        assertFalse(checkValidProfile(inValidProfile));
    }

    @Test
    void testCheckValidProfile_heightLessThanLowerBound_returnFalse() {
        Profile inValidProfile = new Profile(EXAMPLE_NAME, EXAMPLE_AGE, HEIGHT_LOWER_BOUND - 1, EXAMPLE_WEIGHT,
                EXAMPLE_EXPECTED_WEIGHT);
        assertFalse(checkValidProfile(inValidProfile));
    }

    @Test
    void testCheckValidProfile_heightGreaterThanUpperBound_returnFalse() {
        Profile inValidProfile = new Profile(EXAMPLE_NAME, EXAMPLE_AGE, HEIGHT_UPPER_BOUND + 1, EXAMPLE_WEIGHT,
                EXAMPLE_EXPECTED_WEIGHT);
        assertFalse(checkValidProfile(inValidProfile));
    }

    @Test
    void testCheckValidProfile_weightLessThanLowerBound_returnFalse() {
        Profile inValidProfile = new Profile(EXAMPLE_NAME, EXAMPLE_AGE, EXAMPLE_HEIGHT, WEIGHT_LOWER_BOUND - 1,
                EXAMPLE_EXPECTED_WEIGHT);
        assertFalse(checkValidProfile(inValidProfile));
    }

    @Test
    void testCheckValidProfile_weightGreaterThanUpperBound_returnFalse() {
        Profile inValidProfile = new Profile(EXAMPLE_NAME, EXAMPLE_AGE, EXAMPLE_HEIGHT, WEIGHT_UPPER_BOUND + 1,
                EXAMPLE_EXPECTED_WEIGHT);
        assertFalse(checkValidProfile(inValidProfile));
    }
}
