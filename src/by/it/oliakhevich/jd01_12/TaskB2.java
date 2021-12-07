package by.it.oliakhevich.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
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
    public static void main (String[]args){
        String[] names = {"dmitry", "daniil", "dmitry 1", "daniil 1"};
        ArrayList<String> people1 = new ArrayList<>(Arrays.asList(names));
        LinkedList<String> people2 = new LinkedList<>(Arrays.asList(names));
        System.out.println(process(people1));
        System.out.println(process(people2));
    }
}
