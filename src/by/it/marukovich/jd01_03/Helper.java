package by.it.marukovich.jd01_03;

public class Helper {
    static double findMin(double[] array) {
        double min = array[0];
        for (double element : array) {
            if (min > element) min = element;
        }
        System.out.println("\nМинимальный элемент массива " + min);
        return min;

    }

    static double findMax(double[] array) {
        double max = array[0];
        for (double element : array) {
            if (max < element) max = element;
        }
        System.out.println("Максимальный элемент массива " + max);
        return max;

    }

    static void sort(double[] array) {
        boolean elementSwapped;
        double lastElement = array.length - 1;
        do {
            elementSwapped = false;
            for (int i = 0; i < lastElement; i++) {
                if (array[i] > array[i + 1]) {
                    double buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    elementSwapped = true;
                }
            }
        }
        while (elementSwapped);
        System.out.println("Отсортированный массив");
        InOut.printArray(array, "V", 5);
    }

    static double[] multiply(double[][] matrix, double[] vector) {
        double[] multiplyMatrixVectorResult = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++)
                multiplyMatrixVectorResult[i] = multiplyMatrixVectorResult[i] + matrix[i][j] * vector[j];


        }
        return multiplyMatrixVectorResult;
    }

    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {
        double[][] multiplyMatrixMatrixResult = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    multiplyMatrixMatrixResult[i][j] = multiplyMatrixMatrixResult[i][j] + matrixLeft[i][k] * matrixRight[k][j];
        return multiplyMatrixMatrixResult;
    }
}

