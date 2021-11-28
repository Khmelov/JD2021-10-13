package by.it.karpovich.jd01_12;

// TaskC2. Попробуйте решить заново задачу TaskA2 для любого количества
//множеств на входе метода, а также для различных типов чисел в множествах
//(generics). Например, на входе три множества Long, Byte, Float.
// Важно: сравнивать нужно значения. Например, считается, что 1L==1.0F
// В main покажите работоспособность решения.

import java.util.*;

public class TaskC2 {

    public static void main(String[] args) {
        Set<Set<Float> > list = new HashSet<>();

        Set<Integer> integers = new HashSet<>();
        integers.addAll(Arrays.asList(9, 9, 8, 8, 7, 7, 6, 5, 5, 4));

        Set<Double> doubles = new HashSet<>();
        doubles.addAll(Arrays.asList(9.5, 4.2, 5.1, 4.1, 8.1));

        Set<Long> longs = new HashSet<>();
        longs.addAll(Arrays.asList(9l, 255l, 29l));


        list.add(listToFloat(integers));
        list.add(listToFloat(doubles));
        list.add(listToFloat(longs));

        System.out.println(list.toString());
    }

    private static Set<Float> listToFloat(Set<? extends Number> l){
        Set<Float> floats = new HashSet<>();
        for (Number i: l) {
            floats.add(i.floatValue());
        }
        return floats;
    }


    private static  Set<Number> getUnion(Set<? extends Number>... setsArray) {
        Set<Number> result = new HashSet<>();
        for (Set<? extends Number> set: setsArray) {
            result.addAll(listToFloat(set));
        }
        return result;
    }

    private static  Set<Number> getCross(Set<? extends Number>... setsArray) {
        Set<Number> result = new HashSet<>();

        result.addAll(listToFloat(setsArray[0]));
        for (int i = 1; i < setsArray.length; i++) {
            result.retainAll(listToFloat(setsArray[i]));
        }
        return result;
    }




}
