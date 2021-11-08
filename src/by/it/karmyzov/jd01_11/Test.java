package by.it.karmyzov.jd01_11;

import java.util.ArrayList;
import java.util.Collection;

public class Test {
    public static void main(String[] args) {
        Collection<Integer> List1 = new ArrayList<>();
        List1.add(1);
        List1.add(2);
        List1.add(3);
      //  System.out.println(List1.add(1));
        // System.out.println(List1.size());
        Collection<Integer> List2 = new ArrayList<>();
        List2.addAll(List1);
        System.out.println(List2+ " " +List2.size());
    }

}
