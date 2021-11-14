package by.it._classwork_.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;

public class TaskB3 {

    public static void main(String[] args) {
        ArrayList<String> source = new ArrayList<>();
        for (int i = 0; i < 409600; i++) {
            source.add(Integer.toString(i));
        }
        long time = System.nanoTime();
        String lastElement = process(new ArrayList<>(source));
        System.out.printf("ArrayList last=%s t=%d ns%n" , lastElement , (System.nanoTime() - time));

        long time2 = System.nanoTime();
        String lastElement2 = process(new LinkedList<>(source));
        System.out.printf("LinkedList last=%s t=%d ns%n" , lastElement2, (System.nanoTime() - time2));
    }

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
