package by.it.ena.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;

public class TaskB2 {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Катя");
        arrayList.add("Оля");
        arrayList.add("Миша");
        arrayList.add("Вася");
        arrayList.add("Вадим");
        arrayList.add("Гена");
        arrayList.add("Лена");
        arrayList.add("Коля");
        arrayList.add("Поля");

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Коля");
        linkedList.add("Петя");
        linkedList.add("Оля");
        linkedList.add("Дима");
        linkedList.add("Женя");
        linkedList.add("Влад");
        linkedList.add("Вадим");
        linkedList.add("Маша");
        linkedList.add("Катя");

        String first = process(arrayList);
        System.out.println(first);

        String second = process(linkedList);
        System.out.println(second);
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

