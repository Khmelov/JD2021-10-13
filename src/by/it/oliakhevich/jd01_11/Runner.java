package by.it.oliakhevich.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> arrayList = new ArrayList<>();
        //Проверка добавления
        myList.add("First"); arrayList.add("First");
        myList.add("Two");arrayList.add("Two");
        myList.add("Four");arrayList.add("Four");
        System.out.println("add myList"+myList+"\narrayList"+arrayList);
        myList.add(2,"Tree"); arrayList.add(2,"Tree");
        myList.add(0,"Start");arrayList.add(0,"Start");
        System.out.println("add (index)myList"+myList+"\narrayList"+arrayList);
        //Проверка удаления
        myList.remove("Start");arrayList.remove("Start");
        myList.remove(3);arrayList.remove(3);
        System.out.println("remove myList"+myList+"\narrayList"+arrayList);
        //Проверка чтения
        System.out.println("get myList(o):"+myList.get(0)+"\narrayList(o)"+arrayList.get(0));
    }


}
