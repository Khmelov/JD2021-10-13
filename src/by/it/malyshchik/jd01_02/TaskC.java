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
}







