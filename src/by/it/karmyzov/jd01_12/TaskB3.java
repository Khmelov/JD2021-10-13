package by.it.karmyzov.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> source = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            source.add(Integer.toString(i));

        }
        long time = System.nanoTime();
        String lastElement = process(new ArrayList<>(source));
        System.out.printf("ArrayList last=%s t=%d ns%n", lastElement, (System.nanoTime() - time));

        long time2 = System.nanoTime();
        String lastElement2 = process(new ArrayList<>(source));
        System.out.printf("LinkedList last=%s t=%d ns%n", lastElement2, (System.nanoTime() - time2));
    }

    static String process(ArrayList<String> people) {
        while (people.size() > 1) {
            String next = people.remove(0);
            people.remove(0);
            people.add(next);
        }
        return people.get(0);
    }

    static String process(LinkedList<String> people) {
        while (people.size() > 1) {
            String next = people.pollFirst();
            people.pollFirst();
            people.addLast(next);
        }
        return people.get(0);
    }
}

