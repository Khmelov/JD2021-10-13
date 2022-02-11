package by.it.antipov.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List <String> list= new ArrayList<>();
        Set<String> set = new SetC<>();
        list.add(null);
        list.add("1");
        list.add("2");
set.addAll(list);
        System.out.println(list);
        System.out.println(set);
       boolean a = set.contains(null);
        System.out.println(a);
    }
}
