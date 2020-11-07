package models;

public class Exercise {

    private final String moveName;
    private final int repetitions;
    private final double weight;

    public Exercise(String moveName, int repetitions, double weight) {

        this.moveName = moveName;
        this.repetitions = repetitions;
        this.weight = weight;
    }

    @Override
    public String toString() {

        return moveName
                + ", Repetitions:" + repetitions
                + ", Weight=" + weight;
    }

    public String getDescription() {
        return moveName;
    }

    public String getRepetitions() {
        return Integer.toString(repetitions);
    }

    public String getWeight() {
        return Double.toString(weight);
    }
}
