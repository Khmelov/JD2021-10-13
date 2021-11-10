package by.it.malyshchik.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList=new ListA<>();
        List<String> arList=new ArrayList<>();
        //check add
        myList.add("first"); arList.add("first");
        myList.add("two"); arList.add("two");
        myList.add("four"); arList.add("four");
        System.out.println("add myList:"+myList+"\narList:"+arList);
        myList.add(2,"tree"); arList.add(2,"tree");
        myList.add(0,"start"); arList.add(0,"start");
        System.out.println("add() myList:"+myList+"\narList:"+arList);
        //check remove
        myList.remove("start"); arList.remove("start");
        myList.remove(3); arList.remove(3);
        System.out.println("remove myList:"+myList+"\narList:"+arList);
        //проверим чтение
        System.out.println("get myList(0):"+myList.get(0)+"\narList(0):"+arList.get(0));
    }
}
