package by.it.ena.jd01_11;

import by.it._classwork_.jd01_11.ListA;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<String> list = new by.it._classwork_.jd01_11.ListA<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.remove("hi");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println("get(1)="+list.get(1));        
        
        List<Integer> list2 = new ListA<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        System.out.println(list2);
        list2.remove(2);
        System.out.println(list2);
        System.out.println("get(1)="+list2.get(1));
    }
}
