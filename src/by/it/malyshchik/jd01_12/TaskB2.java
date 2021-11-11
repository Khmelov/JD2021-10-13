package by.it.malyshchik.jd01_12;

//Считалка. В кругу стоят N человек.
// При ведении счета по кругу итератором вычеркивается каждый второй человек,пока не останется один.
// Нужно составить два метода, моделирующие процесс и возвращающие имя оставшегося человека:
//   static String process(ArrayList<String> peoples)
//   static String process(LinkedList<String> peoples)
//        Покажите работу методов в main

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {



    public static void main(String[] args) {
        System.out.println(process((ArrayList<String>) Arrays.asList("1, 2, 3, 4, 5")));
        System.out.println(process((LinkedList<String>) Arrays.asList("1, 2, 3, 4, 5")));
    }

    static String process(ArrayList<String> peoples) {
        boolean a = false;
        while (peoples.size()>1){
            Iterator<String> iterator = peoples.iterator();
            while(iterator.hasNext()){
                iterator.next();

                if (a) {
                    iterator.remove();
                }
                a=!a;
            }

        }

        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples){
        while (peoples.size()>1){
            String s = peoples.removeFirst();
            peoples.addLast(s);
            peoples.removeFirst();
        }
        return peoples.get(0);
    }


}
