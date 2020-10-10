package profile.components;

/**
 * A class that manages user profile.
 */
public class Profile {

    protected String name;
    protected int age;
    protected int height;
    protected double weight;
    protected double expectedWeight;
    protected double bmi;

    /**
     * Constructs Profile object.
     *
     * @param name User's name.
     * @param age User's age.
     * @param height User's height in centimeters.
     * @param weight User's weight in kilograms.
     * @param expectedWeight User's expected weight in kilograms.
     */
    public Profile(String name, int age, int height, double weight, double expectedWeight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.expectedWeight = expectedWeight;
        bmi = weight / Math.pow(height / 100, 2);
    }

    /**
     * Overrides toString method of class Object to get string presentation of Profile object.
     *
     * @return String presentation of Profile object.
     */
    public String toString() {
        return String.format(Constants.PROFILE_STRING_REPRESENTATION, name, age, height, weight, expectedWeight);
    }

    /**
     * Gets user's name.
     *
     * @return User's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets user's age.
     *
     * @return User's age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets user's height.
     *
     * @return User's height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Gets user's weight.
     *
     * @return User's weight.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gets user's expected weight.
     *
     * @return User's expected weight.
     */
    public double getExpectedWeight() {
        return expectedWeight;
    }
}
