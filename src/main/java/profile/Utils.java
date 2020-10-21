package profile;

/**
 * A class containing utility methods used in Profile Menu.
 */
public class Utils {
    /**
     * Verifies if user's input when creating profile is valid.
     *
     * @param profile User Profile object.
     * @return Whether input profile is valid.
     */
    public static boolean checkValidProfile(Profile profile) {
        return (checkValidName(profile.getName())
                && checkValidAge(profile.getAge())
                && checkValidHeight(profile.getHeight())
                && checkValidWeight(profile.getWeight())
                && checkValidWeight(profile.getExpectedWeight()));
    }

    /**
     * Verifies if user's input name is not empty string.
     *
     * @param name User's input name.
     * @return Whether input name is valid.
     */
    public static boolean checkValidName(String name) {
        return !name.isEmpty();
    }

    /**
     * Verifies if user's input age is in the valid range
     * (between {@link AGE_LOWER_BOUND} and {@link AGE_UPPER_BOUND} inclusive).
     *
     * @param age User's input age.
     * @return Whether input age is valid.
     */
    public static boolean checkValidAge(int age) {
        return (age >= Constants.AGE_LOWER_BOUND && age <= Constants.AGE_UPPER_BOUND);
    }

    /**
     * Verifies if user's input height is in the valid range
     * (between {@link HEIGHT_LOWER_BOUND} and {@link HEIGHT_UPPER_BOUND} inclusive).
     *
     * @param height User's input height.
     * @return Whether input height is valid.
     */
    public static boolean checkValidHeight(int height) {
        return (height >= Constants.HEIGHT_LOWER_BOUND && height <= Constants.HEIGHT_UPPER_BOUND);
    }

    /**
     * Verifies if user's input weight is in the valid range
     * (between {@link WEIGHT_LOWER_BOUND} and {@link WEIGHT_UPPER_BOUND} inclusive).
     *
     * @param weight User's input weight.
     * @return Whether input weight is valid.
     */
    public static boolean checkValidWeight(double weight) {
        return (weight >= Constants.WEIGHT_LOWER_BOUND && weight <= Constants.WEIGHT_UPPER_BOUND);
    }
}