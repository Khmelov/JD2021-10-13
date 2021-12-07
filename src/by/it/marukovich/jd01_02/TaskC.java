package by.it.marukovich.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер матрицы n");
        int n = scanner.nextInt();
        int[][] arr = step1(n);
        int amount = step2(arr);
        int[][] updatedMatrix = step3(arr);
    }

    static int[][] step1(int n) {

        int[][] array = new int[n][n];
        boolean isNegativeNHere = false;
        boolean isPositiveNHere = false;
        do {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = (int) (Math.random() * (n * 2 + 1)) - n;
                    if (array[i][j] == -n) {
                        isNegativeNHere = true;
                    } else if (array[i][j] == n) {
                        isPositiveNHere = true;
                    }

                }
            }
        }
        while (!(isNegativeNHere) && isPositiveNHere);
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }

        return array;
    }

    static int step2(int[][] arr) {
        int amount = 0;
        boolean isPositive;
        for (int[] ints : arr) {
            isPositive = false;
            for (int j = 0; j < ints.length - 1; j++) {
                if (ints[j] > 0) {
                    isPositive = true;
                }
                if (isPositive) {
                    if (!(ints[j + 1] > 0)) {
                        amount += ints[j + 1];
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(amount);
        return amount;
    }

    protected static int[][] step3(int[][] array) {

        int max = getMaximum(array);

        boolean[] skipCols = new boolean[array[0].length];
        boolean[] skipRows = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == max) {
                    skipCols[j] = true;
                    skipRows[i] = true;
                }
            }
        }

        int rows = 0;
        for (boolean skipRow : skipRows) {
            if (!skipRow) {
                rows++;
            }
        }

        int cols = 0;
        for (boolean skipCol : skipCols) {
            if (!skipCol) {
                cols++;
            }
        }

        int[][] out = new int[rows][cols];
        for (int i = 0, iOut = 0; i < array.length; i++) {
            if (!skipRows[i]) {
                for (int j = 0, jOut = 0; j < array[i].length; j++) {
                    if (!skipCols[j]) {
                        out[iOut][jOut++] = array[i][j];
                    }
                }
                iOut++;
            }
        }

        return out;
    }

    private static int getMaximum(int[][] array) {
        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }
}
