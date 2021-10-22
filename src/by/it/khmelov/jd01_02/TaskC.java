package by.it.khmelov.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        step1(9);
        int[][] resultStep1 = step1(n);
        System.out.println(Arrays.deepToString(resultStep1));

    }

    private static int[][] step1(int max) {
        int[][] array = new int[max][max];
        boolean maxFound;
        boolean minFound;
        do {
            maxFound = false;
            minFound = false;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = -max + (int) (Math.round(Math.random() * (2 * max + 1)));
                    if (array[i][j] == -max) {
                        minFound = true;
                    }
                    if (array[i][j] == max) {
                        maxFound = true;
                    }
                }
            }
        } while (!maxFound || !minFound);
        return array;
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
