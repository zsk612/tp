package profile;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static profile.Constants.EXAMPLE_AGE;
import static profile.Constants.EXAMPLE_EXPECTED_WEIGHT;
import static profile.Constants.EXAMPLE_HEIGHT;
import static profile.Constants.EXAMPLE_NAME;

class ProfileTest {

    @Test
    void testGetBmiClassification_underweightInput_returnUnderweight() {
        Profile testProfile = new Profile(EXAMPLE_NAME, EXAMPLE_AGE, EXAMPLE_HEIGHT, 54, EXAMPLE_EXPECTED_WEIGHT);
        assertEquals("15.3 (Underweight)", testProfile.getBmiClassification());
    }

    @Test
    void testGetBmiClassification_normalWeightInput_returnNormalWeight() {
        Profile testProfile = new Profile(EXAMPLE_NAME, EXAMPLE_AGE, EXAMPLE_HEIGHT, 70, EXAMPLE_EXPECTED_WEIGHT);
        assertEquals("19.8 (Normal Weight)", testProfile.getBmiClassification());
    }

    @Test
    void testGetBmiClassification_overweightInput_returnOverweight() {
        Profile testProfile = new Profile(EXAMPLE_NAME, EXAMPLE_AGE, EXAMPLE_HEIGHT, 100, EXAMPLE_EXPECTED_WEIGHT);
        assertEquals("28.3 (Overweight)", testProfile.getBmiClassification());
    }

    @Test
    void testGetBmiClassification_obesityClassOneInput_returnObesityClassOne() {
        Profile testProfile = new Profile(EXAMPLE_NAME, EXAMPLE_AGE, EXAMPLE_HEIGHT, 113, EXAMPLE_EXPECTED_WEIGHT);
        assertEquals("32.0 (Obesity Class 1)", testProfile.getBmiClassification());
    }

    @Test
    void testGetBmiClassification_obesityClassTwoInput_returnObesityClassTwo() {
        Profile testProfile = new Profile(EXAMPLE_NAME, EXAMPLE_AGE, EXAMPLE_HEIGHT, 127, EXAMPLE_EXPECTED_WEIGHT);
        assertEquals("35.9 (Obesity Class 2)", testProfile.getBmiClassification());
    }

    @Test
    void testGetBmiClassification_extremeObesityClassThreeInput_returnExtremeObesityClassThree() {
        Profile testProfile = new Profile(EXAMPLE_NAME, EXAMPLE_AGE, EXAMPLE_HEIGHT, 148, EXAMPLE_EXPECTED_WEIGHT);
        assertEquals("41.9 (Extreme Obesity Class 3)", testProfile.getBmiClassification());
    }
}
