/*
        Создайте в пакете by.it.familiya.jd01_02 класс TaskA.
        В методе main введите 10 чисел с консоли в массив arr через объект типа
        Scanner. Пример: Scanner scanner=new Scanner(System.in);
        В классе TaskA создайте статические методы
        static void step1(int[ ] arr)
        static void step2(int[ ] arr)
        static void step3(int[ ] arr)
        и вызовите их из метода main. Эти методы решают такие задачи:
     1. Найти самое маленькое и самое большое число массива. Вывести на
        консоль найденные минимум и максимум в одну строку через пробел.
     2. Вывести на консоль те числа, значение которых строго меньше
        среднего арифметического (типа double) в этом массиве.
     3. Найти и вывести номер (т.е. индекс) самого маленького числа.
        Если же таких чисел будет несколько, вывести все найденные индексы
        минимума через пробел в порядке убывания
_______________________________________________________________________________________________________________________
*/
package by.it.karpovich.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);
    }

    private static void step1(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int element : arr) {
            if (min > element) min = element;
            if (max < element) max = element;
        }
        System.out.println(min + " " + max);
    }


    private static void step2(int[] arr) {
        double avg = 0;
        for (int element : arr) {
            avg += element;
        }
        avg = avg / arr.length;
        for (int element : arr) {
            if (element < avg)
                System.out.print(element + " ");
        }
    }

    private static void step3(int[] arr) {
        int min = arr[0];
        for (int element : arr) {
            if (min > element) min = element;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == min) System.out.print(i + " ");
        }
    }
}

