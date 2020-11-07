package models;

//@@author yujinyang1998
public class Exercise {

    private final String MOVE_NAME;
    private final int REPETITIONS;
    private final double WEIGHT;

    public Exercise(String MOVE_NAME, int REPETITIONS, double WEIGHT) {

        this.MOVE_NAME = MOVE_NAME;
        this.REPETITIONS = REPETITIONS;
        this.WEIGHT = WEIGHT;
    }

    @Override
    public String toString() {

        return MOVE_NAME
                + ", Repetitions:" + REPETITIONS
                + ", Weight=" + WEIGHT;
    }

    public String getDescription() {
        return MOVE_NAME;
    }

    public String getRepetitions() {
        return Integer.toString(REPETITIONS);
    }

    public String getWeight() {
        return Double.toString(WEIGHT);
    }
}
