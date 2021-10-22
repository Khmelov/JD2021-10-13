package by.it.malyshchik.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        System.out.println("Введите размерность матрицы:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        step1(n);
    }

    static int[][] step1(int maxSize) {
        Random random = new Random();
        int[][] array = new int[maxSize][maxSize];
        boolean maxFound;
        boolean minFound;
        do {
            maxFound = false;
            minFound = false;

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = (int) (-maxSize + random.nextInt(2 * maxSize + 1));
                    if (array[i][j] == -maxSize) {
                        minFound = true;
                    }
                    if (array[i][j] == maxSize) {
                        maxFound = true;
                    }
                }
            }
            System.out.println(array);
        }
        while (!maxFound || !minFound);
        return array;

       }
//        while ();
//            int max = a
//        boolean min = false;
//        boolean max = false;
//        do {
//            for (int i = 0; i < a.length; i++) {
//                for (int j = 0; j < a[i].length; j++)
//                    a[i][j] = (int) (-n + random.nextInt(2 * n + 1));
//
//            }
//            for (int i = 0; i < a.length; i++, System.out.println()) {
//                for (int j = 0; j < a[i].length; j++) {
//                    System.out.print(a[i][j] + " ");
//                    if (i == -n) min = true;
//                  if (i == n) max = true;
//                }
//            }
//        }
//
//            while (!max || !min) ;
//            System.out.println("В массиве нет максимума n или минимума -n");
//                System.out.println("Введите размерность матрицы:");


    }



//        boolean min = false;
//        boolean max = false;
//            do (int[] row : a)
//                for (int i : row) {
//                    if (i == -n) min = true;
//                    if (i == n) max = true;
//                }
//            if (!max || !min) {
//                System.out.println("В массиве нет максимума n или минимума -n");
//                System.out.println("Введите размерность матрицы:");







