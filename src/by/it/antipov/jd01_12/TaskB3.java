package by.it.antipov.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    static String process(ArrayList<String> people) {
        int i = 1;
        while (people.size() != 1) {
            Iterator<String> iterator = people.iterator();
            int a = people.size();
            for (int j = 0; j < a; j++) {
                iterator.next();
                if (i % 2 == 0) {
                    iterator.remove();
                }
                i++;
            }
        }
        return people.iterator().next();
    }

    static String process(LinkedList<String> people) {
        int i = 1;
        while (people.size() != 1) {
            if (i % 2 != 0) {
                people.addLast(people.peekFirst());
            }
            people.removeFirst();

            i++;
        }
        return people.iterator().next();
    }
    public static void main (String[]args){
        String[] names = {"kir", "nast", "kir1", "nast1"};
        ArrayList<String> people1 = new ArrayList<>(Arrays.asList(names));
        LinkedList<String> people2 = new LinkedList<>(Arrays.asList(names));
        long inTime1 = System.nanoTime();
        System.out.println(process(people1));
        double delta1 = System.nanoTime()-inTime1;
        long inTime2 = System.nanoTime();
        System.out.println(process(people2));
        double delta2 = System.nanoTime()-inTime2;
        System.out.println(delta1);
        System.out.println(delta2);
    }
}
