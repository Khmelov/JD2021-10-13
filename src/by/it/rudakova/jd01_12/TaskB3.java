package by.it.rudakova.jd01_12;

import org.junit.rules.Stopwatch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB3 {
    public static void main(String[] args) {
        int number=4096;

        ArrayList<String> peopleArrayList = new ArrayList<>();
        fillCollection(peopleArrayList, number);

        LinkedList<String> peopleLinkedList = new LinkedList<>();
        fillCollection(peopleLinkedList,number);

        long finish=0;
        long start=System.currentTimeMillis();

        String firstName = process(peopleArrayList);
        System.out.println(firstName);
        finish=System.currentTimeMillis();
        System.out.println("Работа ArrayList: "+(finish-start));

        start=System.currentTimeMillis();
        String secondName = process(peopleLinkedList);
        System.out.println(secondName);
        finish=System.currentTimeMillis();
        System.out.println("Работа LinkedList: "+(finish-start));
    }

    static String process(ArrayList<String> peoples) {
        int i = 0;
        while (peoples.size() != 1) {
            Iterator iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (i % 2 != 0) {
                    iterator.remove();
                }
                i++;
            }
        }

        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        int i = 0;
        while (peoples.size() != 1) {
            Iterator iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (i % 2 != 0) {
                    iterator.remove();
                }
                i++;
            }
        }

        return peoples.get(0);
    }

    private static void fillCollection(List<String> myList, int number) {
        for (int i = 0; i < number; i++) {
            myList.add("name" + i);
        }
    }
}
