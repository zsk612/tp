package workout.workoutSession.excercise;

public class Excercise {
    private String moveName;
    private int repetitions;
    private int weight;

    public Excercise(String moveName, int repetitions, int weight){
        moveName = this.moveName;
        repetitions = this.repetitions;
        weight = this.weight;
    }

    @Override
    public String toString() {
        return  moveName +
                ", Repetitions:" + repetitions +
                ", Weight=" + weight;
    }
}
