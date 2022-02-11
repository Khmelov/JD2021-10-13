package by.it.karmyzov.jd01_03;

public class Helper {
    static double findMax(double[] array) {

        if (0 == array.length) {
            return Double.MAX_VALUE;
        } else {
            double max = array[0];
            for (double m : array) {
                if (max < m) max = m;
            }
            return max;
        }
    }

    static double findMin(double[] array) {
        if (0 == array.length) {
            return Double.MIN_VALUE;
        } else {
            double min = array[0];
            for (double m : array) {
                if (min > m) min = m;
            }
            return min;
        }
    }

    public static void sort(double[] array) {
        boolean swap;
        double last = array.length - 1;
        do {
            swap = false;
            for (int j = 0; j < last; j++) {
                if (array[j] > array[j + 1]) {
                    double buffer = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);

    }

    static double[] multiply(double[][] matrix, double[] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++) {
                z[i] = z[i] + matrix[i][j] * vector[j];
            }
        return z;
    }


    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {
        double[][] z = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    z[i][j] = z[i][j] + matrixLeft[i][k] * matrixRight[k][j];
        return z;
    }

}


