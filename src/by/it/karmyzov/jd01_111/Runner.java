package by.it.karmyzov.jd01_111;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {


        ListB<Long> listB = new ListB<>();
        ArrayList<Integer> arrayListB = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            listB.add(i * 4L);
        }
        System.out.println(listB);
        listB.add(9, null);
        System.out.println(listB);

    }
}

