package by.it.malyshchik.jd01_12;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskA3 {
//    В main класса TaskA3 вводите список чисел с клавиатуры до ввода слова “end”.
//    Переставьте отрицательные элементы списка чисел в конец, а положительные —
//    в начало списка, сохраняя их порядок относительно друг друга.
//    Выведите список на консоль методом коллекции toString().

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> values = new ArrayList<>();
        int posZero = 0;
        for (; ; ){
            String value = sc.next();
            if (!value.equals("end")){
                Integer i = Integer.valueOf(value);
                if(i<0){
                    values.add(i);
                } else if (i>0) {
                    values.add(posZero++, i);
                } else {
                    values.add(posZero, i);
                }
            } else {
                break;
            }

        }
        System.out.println("values: "+ values);
    }

}
