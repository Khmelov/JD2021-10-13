package by.it.karmyzov.Test.Collections.Map;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class LinkedHashMapX {
    public static void main(String[] args) {
        LinkedHashMap<Double,Student> lhm = new LinkedHashMap<>(16, 0.75f,false);
        Student st1 = new Student(" Zaur", "Tregulov", 3);
        Student st2 = new Student("Sergio", "Belii", 5);
        Student st3 = new Student(" Kalar", "Trooov", 4);
        Student st4 = new Student(" Dima", "Trim", 3);

lhm.put(6.4, st2);
lhm.put(6.0, st1);
lhm.put(5.8, st3);
lhm.put(7.5, st4);
        System.out.println(lhm);
        System.out.println(lhm.get(5.8));
        System.out.println(lhm.get(7.5));
        System.out.println(lhm);


    }
}
