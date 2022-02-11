package by.it.antipov.jd01_03;

public class Helper {
    static double findMin(double[] array) {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            System.out.println(min);
        }
        return min;
    }

    static double findMax(double[] array) {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            System.out.println(max);
        }
        return max;
    }

    static void sort(double[] array) {
        for (int a = 0; a < array.length - 1; a++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i + 1] < array[i]) {
                    double buffer = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = buffer;
                }
            }
        }
    }

    static double[] multiply(double[][] matrix, double[] vector) {

        double[] resultArray = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < vector.length; j++) {
                resultArray[i] = resultArray[i] + (matrix[i][j] * vector[j]);

            }
            System.out.print(resultArray[i]);

        }
        return resultArray;
    }

    static double[][] multiply(double[][] matrixLeft, double[][] matrixRight) {
        double[][] resultArray = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < resultArray.length; i++) {System.out.println();
            for (int j = 0; j < resultArray[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    resultArray[i][j]=resultArray[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }

            }

        }
        return resultArray;
    }



}