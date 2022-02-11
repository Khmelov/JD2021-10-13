package by.it.karmyzov.Test.Collections.HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class HashSet {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("kak dela ?");
        list.add("poka");
        list.add("OK");
//        for (int i = 0; i < list.size(); i++) {
//            list.set(i, String.valueOf(list.get(i).length()));
//
//        }
        List<Integer> list2 = list.stream().map(element->element.length())
                        .collect(Collectors.toList());
        System.out.println(list2);
        int [] array = {5,9,3,8,1};
       array = Arrays.stream(array).map(element
                -> {if (element%3==0) {
                    element = element/3;
        }
        return element;
        } ).toArray();
        System.out.println(Arrays.toString(array));
        Set<String> set = new TreeSet<>();
        set.add("privet");
        set.add("kak dela ?");
        set.add("poka");
        set.add("OK");
        System.out.println(set);
        Set<Integer> set2= set.stream().map(e -> e.length()).collect(Collectors.toSet());
        List<Integer> list3= set.stream().map(e -> e.length()).collect(Collectors.toList());
        System.out.println(set2);
        System.out.println(list3);

//        Set<String> set = new java.util.HashSet<>();
//        set.add("Zaup");
//        set.add("Oleg");
//        set.add("Marina");
//        set.add("Igor");
//
//        //System.out.println(set);
//        for (String s : set) {
//            System.out.println(s);
//        }
//        System.out.println(set.size());
//        System.out.println(set.isEmpty());
//        System.out.println(set.contains("Zaup"));

    }

    }
