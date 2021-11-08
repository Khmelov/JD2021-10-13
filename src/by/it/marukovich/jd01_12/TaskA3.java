package by.it.marukovich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new java.util.Scanner(System.in);
        List<Integer> values = new ArrayList<>();
        int posZero = 0;
        for(;;){
            String value = scanner.next();
            if (value.equals("end")){
                Integer i = Integer.valueOf(value);
                if(i<0){
                    values.add(i);
                } else if (i>0){
                    values.add(posZero++, i);
                } else {
                    values.add(posZero, i);
                }
            } else {
                break;
            }
        }
        System.out.println("values: " + values);
    }
}
