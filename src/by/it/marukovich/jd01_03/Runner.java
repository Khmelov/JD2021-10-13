package by.it.marukovich.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "V", 5);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        double[][] matrix = {
                {2, 5, 4, 1},
                {1, 3, 2, 1},
                {2, 10, 9, 7},
                {3, 8, 9, 2}
        };
        double[] vector = {1, 5, 9, 8};
        double[][] matrix1 = {
                {1, 4, 3, 2},
                {2, 2, 1, 2},
                {1, 9, 8, 6},
                {2, 7, 8, 1}
        };
        Helper.multiply(matrix, vector);
        InOut.printArray(Helper.multiply(matrix, vector), "Z", 1);
        Helper.multiply(matrix, matrix1);
        InOut.matrixPrint2D(Helper.multiply(matrix, matrix1), "AB");
    }
}
