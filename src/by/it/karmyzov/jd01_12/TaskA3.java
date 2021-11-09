package by.it.karmyzov.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> arr =new ArrayList<>();
        Scanner sc  = new Scanner(System.in);
        String str;
        int pos = 0;
        while (!(str = sc.next()).equals("end")) {
            int value = Integer.valueOf(str);
                       if (value > 0)
                arr.add(pos++, value);
            else if (value == 0)
                arr.add(pos, 0);
            else
                arr.add(value);
        }
        System.out.println(arr);
         }
        }


//        List<Integer> values = new ArrayList<>();
//        for (; ; ) {
//            String word = sc.next();
//            if (!word.equals("end")) {
//                Integer i = Integer.valueOf(word);
//                if (i<0) {
//                    values.add(i);
//                }
//            } else; {
//
//                    break;
//