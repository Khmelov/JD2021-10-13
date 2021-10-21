package by.it.khmelov.jd01_02;

import java.util.Arrays;

public class TaskC {

    public static void main(String[] args) {
        int[][] array = {
                //  X  X        X
                {1, 9, 3, 4, 5, 9}, //X
                {1, 2, 3, 3, 2, 0},
                {1, 2, 3, 4, 5, 0},
                {1, 9, 9, 4, 5, 9}, //X
                {1, 2, 3, 4, 5, 9}, //X
        };
        int[][] result = step3(array);
        System.out.println(Arrays.deepToString(result));
    }

    static int[][] step3(int[][] array) {

        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }

        boolean[] delRow = new boolean[array.length];
        boolean[] delCol = new boolean[array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == max) {
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }
        }

        int countRowResult = 0;
        int countColResult = 0;

        for (boolean p : delCol) {
            if (!p) {
                countColResult++;
            }
        }
        for (boolean p : delRow) {
            if (!p) {
                countRowResult++;
            }
        }

        int[][] result = new int[countRowResult][countColResult];

        for (int i = 0, ir = 0; i < array.length; i++) {
            if (!delRow[i]) {
                for (int j = 0, jr = 0; j < array[i].length; j++) {
                    if (!delCol[j]) {
                        result[ir][jr++] = array[i][j];
                    }
                }
                ir++;
            }
        }

        return result;
    }
}
