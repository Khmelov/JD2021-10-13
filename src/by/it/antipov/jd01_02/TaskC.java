package by.it.antipov.jd01_02;

import java.util.Scanner;
import java.util.Random;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = step1(n);
        System.out.println();
        System.out.println(step2(array));
        int[][] array1 = step3(array);
    }

    static int[][] step1(int n) {
        Random random = new Random();
        int[][] arr = new int[n][n];
        int max = arr[0][0];
        int min = arr[0][0];
        for (int a = 0; a < n; a++) {
            System.out.println();
            for (int b = 0; b < n; b++) {
                int value = (-n) + random.nextInt(2 * n + 1);
                arr[a][b] = value;
                if (arr[a][b] > max) {
                    max = arr[a][b];
                }
                if (arr[a][b] < min) {
                    min = arr[a][b];
                }
                System.out.print(value + " ");
            }
        }
        if ((max == n) & (min == (-n))) {
            return arr;
        } else return step1(n);
    }

    static int step2(int[][] array) {
        int n = 0;
        int wholeSum = 0;
        for (int[] element1 : array) {
            n = n + 1;
        }
        for (int a = 0; a < n; a++) {
            int i = 0;
            int sum = 0;
            for (int b = 0; b < n; b++) {
                if (array[a][b] > 0) {
                    i = i + 1;
                }
                if (i != 2 & b == n) {
                    break;
                }
                if ((i % 2 != 0) & (array[a][b] < 0)) {
                    sum = sum + array[a][b];
                }
                if (i > 2) {
                    break;
                }
            }
            wholeSum = wholeSum + sum;
        }
        System.out.println("Сумма");
        return wholeSum;
    }

    static int[][] step3(int[][] array) {
        int n = 0;
        int max = 0;

        int controllerB = -1;
        int controllerA = -1;
        for (int[] element1 : array) {
            n = n + 1;
        }
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (array[a][b] > max) {
                    max = array[a][b];
                }
            }
        }
        System.out.println(" =" + max);

        return array;
    }
}
