package diet.dietmanager;

public class DietManagerParser {
    public String[] parse(String comm) {
        if (comm.contains(" ")) {
            return comm.split(" ", 2);
        } else {
            return new String[]{comm, "filler"};
        }
    }
}
