package by.it.antipov.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list= new ListA ();
        list.add("9");
        list.add("5");
        list.add("8");
        System.out.println(list);
//list.remove(1);
list.set(1,"132");
        System.out.println(list);
    }
}
