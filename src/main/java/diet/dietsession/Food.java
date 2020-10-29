package diet.dietsession;

public class Food {
    protected String name;
    protected double calories;

    public Food(String name, double calories) {
        this.name = name;
        if (calories > 200000) {
            this.calories = 200000;
        } else {
            this.calories = calories;
        }
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
