package by.it.karmyzov.Test.Collections.HashSet;

import java.util.Set;

public class HashSet {
    public static void main(String[] args) {
        Set<String> set = new java.util.HashSet<>();
        set.add("Zaup");
        set.add("Oleg");
        set.add("Marina");
        set.add("Igor");

        //System.out.println(set);
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set.contains("Zaup"));

    }

    }
