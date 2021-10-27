package by.it.ena.jd01_04;

public class Helper {
    static double findMin(double[] array) {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) min = array[i];
        }
        return min;
    }

    static double findMax(double[] array) {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) max = array[i];
        }
        return max;
    }

    static void sort(double[] array) {
        boolean sorted = false;
        double temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    sorted = false;
                }
            }
        }
    }

    static double[] multiply(double[][] matrix, double[] vector) {
        double[] newMatrix = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                newMatrix[i] = newMatrix[i] + matrix[i][j] * vector[j];

            }
        }
        return newMatrix;
    }

    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {
        double[][] newMatrixTwo = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    newMatrixTwo[i][j] = newMatrixTwo[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }

        }
        return newMatrixTwo;
    }
}
