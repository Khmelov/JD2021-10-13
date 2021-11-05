package by.it.marukovich.jd01_11;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println("get(1) = " + list.get(1));

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        System.out.println(list2);
        list2.remove(2);
        System.out.println(list2);
        System.out.println("get(1) = " + list2.get(1));
    }
}
