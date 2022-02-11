package by.it._classwork_.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;

public class TaskB2 {

    static String process(ArrayList<String> peoples) {
        while (peoples.size() > 1) {
            String next = peoples.remove(0);
            peoples.remove(0);
            peoples.add(next);
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            String next = peoples.pollFirst();
            peoples.pollFirst();
            peoples.addLast(next);
        }
        return peoples.get(0);
    }

}
