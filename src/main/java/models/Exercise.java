package models;

public class Exercise {

    private String moveName = null;
    private int repetitions = 0;
    private int weight = 0;

    public Exercise(String moveName, int repetitions, int weight) {

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
        return Integer.toString(weight);
    }
}
