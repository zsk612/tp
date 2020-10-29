package diet.dietsession;

public class Food {
    protected String name;
    protected double calories;

    public Food(String name, double calories) {
        this.name = name;
        this.calories = Math.min(calories, 200000);
    }

    public String toString() {
        return this.name + " with calories: " + this.calories;
    }

    public double getCalories() {
        return calories;
    }

    public String getName() {
        return this.name;
    }
}
