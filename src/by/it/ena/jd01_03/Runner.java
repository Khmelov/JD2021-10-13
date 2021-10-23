package by.it.ena.jd01_03;

import java.util.Arrays;
import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);

        InOut.printArray(array);

        InOut.printArray(array, "V", 3);

        System.out.println(Helper.findMin(array));

        System.out.println(Helper.findMax(array));

        Helper.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }

        System.out.println("Введите двумерный массив 2x2: ");
        double[][] matrix = new double[2][2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        System.out.print("Введите вектор: ");
        double[] vector = new double[2];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = scanner.nextDouble();
        }

        System.out.println("Введите второй двумерный массив 2x2: ");
        double[][] matrixTwo = new double[2][2];
        for (int i = 0; i < matrixTwo.length; i++) {
            for (int j = 0; j < matrixTwo[i].length; j++) {
                matrixTwo[i][j] = scanner.nextDouble();
            }
        }

        double[] newMatrix = Helper.multiply(matrix, vector);
        System.out.println(Arrays.toString(newMatrix));

        double[][] newMatrixTwo = Helper.multiply(matrix, matrixTwo);
        System.out.println(Arrays.deepToString(newMatrixTwo));
    }
}
