package storage;

import diet.dietsession.DietSession;

import java.util.ArrayList;
import java.util.List;

public class DietManagerStorage {
    private static List<DietSession> pastRecords;

    public static void init() {
        pastRecords = new ArrayList<>();
    }

    public static void list(String args[]) {
        int index = 0;
        if(args == null) {
            for(DietSession ws : pastRecords) {
                System.out.print(index + " ");
                System.out.println(ws);
            }
        }
    }

    public static void add(DietSession newSession) {
        pastRecords.add(newSession);
    }
}
