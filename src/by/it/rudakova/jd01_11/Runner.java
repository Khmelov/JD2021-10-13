package by.it.rudakova.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        List <String> listA = new ListA<>();

        listA.add("one");
        listA.add("three");
        listA.add("four");
        listA.add("five");

        List<String> arrayList=new ArrayList<>();
        arrayList.add("one");
        arrayList.add("three");
        arrayList.add("four");
        arrayList.add("five");

        HashSet<String> test = new HashSet<String>();
        test.add("123");
        test.add("abc");
        test.add("32");
        test.add("q");

        System.out.println(test);
        System.out.println("List: "+listA);
        System.out.println("ArrayList: "+arrayList);

        listA.add(0,"start");
        arrayList.add(0,"start");
        listA.add(2,"two");
        arrayList.add(2,"two");

        System.out.println("List: "+listA);
        System.out.println("ArrayList: "+arrayList);

        listA.remove(5);
        arrayList.remove(5);

        System.out.println("List: "+listA);
        System.out.println("ArrayList: "+arrayList);

        listA.remove("start");
        arrayList.remove("start");

        System.out.println("List: "+listA);
        System.out.println("ArrayList: "+arrayList);

        System.out.println("List(0): "+listA.get(0));
        System.out.println("ArrayList(0): "+arrayList.get(0));

        List<String> listB=new ListB<>();

        listB.add("1");
        listB.add("2");
        listB.add("3");
        listB.add("4");
        listB.add("5");

        System.out.println("ListB: "+listB);

        listB.set(0,"6");
        listB.set(0,"1");
        System.out.println("ListB: "+listB);

        listB.addAll(arrayList);

        System.out.println("ListB: "+listB);
    }
}
