package by.it.marukovich.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListA<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println("get(1) = " + list.get(1));

        List<Integer> list2 = new ListA<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        System.out.println(list2);
        list2.remove(2);
        System.out.println(list2);
        System.out.println("get(1) = " + list2.get(1));

        List<Integer> list1 = new ListB<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        System.out.println(list1);
        list1.set(3, 25);
        System.out.println(list1);
        list1.remove(2);
        list1.add(2, 22);
        System.out.println(list1);
        System.out.println("get(1) = " + list1.get(1));
        list1.addAll(1, list2);
        System.out.println(list1);
    }
}
