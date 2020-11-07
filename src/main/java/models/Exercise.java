package models;

//@@author yujinyang1998
public class Exercise {

    private String moveName;
    private int repetitions;
    private double weight;

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
