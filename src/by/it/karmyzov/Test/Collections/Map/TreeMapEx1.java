package by.it.karmyzov.Test.Collections.Map;

import java.util.TreeMap;

public class TreeMapEx1 {
    public static void main(String[] args) {
        TreeMap<Double, Student> treeMap = new TreeMap<>();
        Student st1 = new Student(" Zaur", "Tregulov", 3);
        Student st2 = new Student("Sergio", "Belii", 5);
        Student st3 = new Student(" Kalar", "Trooov", 4);
        Student st4 = new Student(" Dima", "Trim", 3);
        Student st5 = new Student("Ser", "Serii", 5);
        Student st6 = new Student(" Kola", "Ortov", 4);
        Student st7 = new Student(" Sasha", "Voron", 4);
        Student st8 = new Student(" Petr", "Sidorov", 4);

        treeMap.put(4.8, st1);
        treeMap.put(8.9, st2);
        treeMap.put(2.0, st3);
        treeMap.put(3.7, st4);
        treeMap.put(5.0, st5);
        treeMap.put(3.8, st6);
        treeMap.put(8.7, st7);
        treeMap.put(1.7, st8);


//        System.out.println(treeMap.descendingMap());
//        System.out.println(treeMap.headMap(7.3));
//        System.out.println(treeMap.lastEntry());
//        System.out.println(treeMap.firstEntry());
//
//        System.out.println(treeMap);
//        System.out.println(treeMap.get(2.0));
//        System.out.println(treeMap.remove(1.7));
//        System.out.println(treeMap);
//




}
    }



