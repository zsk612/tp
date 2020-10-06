package storage;

import diet.dietsession.DietSession;

import java.util.ArrayList;
import java.util.List;

public class DietManagerStorage {
    private static List<DietSession> pastRecords;

    public static void init() {
        pastRecords = new ArrayList<>();
    }

    public static void list() {
        int index = 1;
        for(DietSession ws : pastRecords) {
            System.out.print((index++) + " ");
            System.out.println(ws);
        }

    }

    public static void add(DietSession newSession) {

        System.out.println("added new diet session");
        pastRecords.add(newSession);
    }
}
