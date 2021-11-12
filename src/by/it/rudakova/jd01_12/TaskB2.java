package by.it.rudakova.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {

        ArrayList<String> peopleArrayList=new ArrayList<>();
        peopleArrayList.add("Таня");
        peopleArrayList.add("Маша");
        peopleArrayList.add("Саша");
        peopleArrayList.add("Коля");
        peopleArrayList.add("Сережа");
        peopleArrayList.add("Вася");
        peopleArrayList.add("Наташа");

        LinkedList<String> peopleLinkedList=new LinkedList<>();
        peopleLinkedList.add("Таня");
         peopleLinkedList.add("Маша");
        peopleLinkedList.add("Саша");
        peopleLinkedList.add("Коля");
        peopleLinkedList.add("Сережа");
        peopleLinkedList.add("Наташа");
        peopleLinkedList.add("Вася");
        peopleLinkedList.add("Петя");

        String firstName=process(peopleArrayList);
        System.out.println(firstName);

       String secondName=process(peopleLinkedList);
       System.out.println(secondName);




    }

    static String process(ArrayList<String> peoples) {
        int i=0;
        while (peoples.size()!=1) {
            Iterator iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (i % 2 != 0) {
                    iterator.remove();
                }
                i++;
            }
        }

        return peoples.get(0);
    }

   static String process(LinkedList<String> peoples){
       int i=0;
       while (peoples.size()!=1) {
           Iterator iterator=peoples.iterator();
           while (iterator.hasNext()) {
               iterator.next();
               if (i % 2 != 0) {
                   iterator.remove();
               }
               i++;
           }
       }

       return peoples.get(0);
   }
}
