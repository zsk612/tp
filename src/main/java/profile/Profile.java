package profile;

/**
 * A class that manages user profile.
 */
public class Profile {
    public static final String PROFILE_STRING_REPRESENTATION = "Name: %s | Age: %d | Height: %d cm | Weight: %f kg"
            + " | Expected Weight: %f kg";

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
        setName(name);
        setAge(age);
        setHeight(height);
        setWeight(weight);
        setExpectedWeight(expectedWeight);
        setBmi();
    }

    /**
     * Sets name field in user's profile.
     *
     * @param name User's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets age field in user's profile.
     *
     * @param age User's age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets height field in user's profile.
     *
     * @param height User's height in centimeters.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Sets weight field in user's profile.
     *
     * @param weight User's weight in kilograms.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Sets expected weight field in user's profile.
     *
     * @param expectedWeight User's expected weight in kilograms.
     */
    public void setExpectedWeight(double expectedWeight) {
        this.expectedWeight = expectedWeight;
    }

    /**
     * Sets BMI filed in user's profile based on weight and height.
     */
    public void setBmi() {
        bmi = weight / Math.pow(height / 100, 2);
    }

    /**
     * Overrides toString method of class Object to get string presentation of Profile object.
     *
     * @return String presentation of Profile object.
     */
    public String toString() {
        return String.format(PROFILE_STRING_REPRESENTATION, name, age, height, weight, expectedWeight);
    }
}
