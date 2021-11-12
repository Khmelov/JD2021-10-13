package by.it.karmyzov.jd01_11;

import java.util.ArrayList;
import java.util.Collection;

public class Test {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Zaur");
        list.add("Ivan");
        list.add("Mar");
        list.add(1, "Misha");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
//        System.out.println();
//        ArrayList <Integer> list2 = new ArrayList<>();
//        list2.add(6);
//        System.out.println(list2);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
        list.set(1, "Masha");
        list.remove(0);
        list.remove(1);
        System.out.println(list);
        }
    }





