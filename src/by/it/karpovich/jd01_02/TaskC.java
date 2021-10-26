package by.it.karpovich.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = step1(n);
        step2(matrix);
        step3();
    }

    static int[][] step1(int n) {

        Random rand = new Random();
        int[][] arr = new int[n][n];
        int min = -n;
        int max = n;

        int minCount;
        int maxCount;

        do {
            minCount = 0;
            maxCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[j][i] = rand.nextInt(n * 10 + 5) - 2*n;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == max) {
                        maxCount++;
                    } else if (arr[i][j] == min) {
                        minCount++;
                    }
                }
            }
        } while (maxCount == 0 || minCount == 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return arr;
    }


    static int step2(int[][] arr) {
        int positiveNumberCounter = 0;
        int[] FirstAndTwoPositiveElement = new int[2];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    FirstAndTwoPositiveElement[positiveNumberCounter] = j;
                    positiveNumberCounter++;
                }
                if (positiveNumberCounter == 2) {
                    for (int k = FirstAndTwoPositiveElement[0] + 1; k < FirstAndTwoPositiveElement[1]; k++) {
                        sum += arr[i][k];
                    }
                    break;
                }
            }
            positiveNumberCounter = 0;
        }
        System.out.println("Сумма: " + sum + "\n");
        return sum;
    }

    private static void step3() {
        System.out.println("Deleted!");
    }

}
