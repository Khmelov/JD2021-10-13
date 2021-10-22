package by.it.ena.jd01_02;

import java.util.Scanner;

//Как ограничить количество вводимых чисел
// если сделать как на видео, 2 и 3 программа слипаются, если использовать printf("\n"+i + " ") тогда не проходят тесты
public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        step1(array);
        step2(array);
        step3(array);
    }

    private static void step1(int [] array) {
        int min = Integer.MAX_VALUE; //задав в переменную изначально минимальное и максимальное число,при первом сравнении оно окажется 100% больше, либо меньше числа.
        int max = Integer.MIN_VALUE;
        for (int element : array) {
            if (min > element) min = element;
            if (max < element) max = element;
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int [] array) {
        double sum = 0;
        for (int element : array) {
            sum = sum + element;
        }
        sum = sum / array.length;
        for (int element : array) {
            if (element < sum)
                System.out.print(element + "  ");
        }
    }

    private static void step3(int [] array) {
        int min = Integer.MAX_VALUE;
        for (int element : array) {
            if (min > element) min = element;
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == min)
                System.out.print(i + " ");
        }
    }
}

