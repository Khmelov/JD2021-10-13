package by.it.karpovich.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = step1(n);
        step2(matrix);
        step3(matrix);
    }

    static int[][] step1(int n) {

        Random rand = new Random();
        int[][] arr = new int[n][n];
        int min = -n;

        int minCount;
        int maxCount;

        do {
            minCount = 0;
            maxCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[j][i] = rand.nextInt(n * 10 + 5) - 2 * n;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == n) {
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

        for (int[] ints : arr) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] > 0) {
                    FirstAndTwoPositiveElement[positiveNumberCounter] = j;
                    positiveNumberCounter++;
                }
                if (positiveNumberCounter == 2) {
                    for (int k = FirstAndTwoPositiveElement[0] + 1; k < FirstAndTwoPositiveElement[1]; k++) {
                        sum += ints[k];
                    }
                    break;
                }
            }
            positiveNumberCounter = 0;
        }
        System.out.println("Сумма: " + sum + "\n");
        return sum;
    }

    private static int[][] step3(int[][] arr) {
        int maxValue = getMaxValue(arr);

        boolean[] rows = new boolean[arr.length];
        boolean[] columns = new boolean[arr[0].length];

        int rowsToDelete = 0;
        int columnsToDelete = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[0].length; k++) {
                if (arr[i][k] == maxValue) {
                    if (!rows[i]) {
                        rows[i] = true;
                        rowsToDelete++;
                    }
                    if (!columns[k]) {
                        columns[k] = true;
                        columnsToDelete++;
                    }
                }

            }
        }

        int[][] resultArray = new int[arr.length - rowsToDelete][arr[0].length - columnsToDelete];

        int resultRow = 0;
        int resultColumn;

        for (int i = 0; i < arr.length; i++) {
            if (rows[i]) {
                continue;
            }
            resultColumn = 0;

            for (int k = 0; k < arr[0].length; k++) {
                if (columns[k]) {
                    continue;
                }
                resultArray[resultRow][resultColumn] = arr[i][k];
                resultColumn++;
            }
            resultRow++;

        }
        return resultArray;
    }

    private static int getMaxValue(int[][] arr) {
        int maxValue = arr[0][0];

        for (int[] ints : arr) {
            for (int k = arr.length - 1; k >= 0; k--) {
                if (maxValue < ints[k]) {
                    maxValue = ints[k];
                }
            }
        }
        return maxValue;
    }


}
