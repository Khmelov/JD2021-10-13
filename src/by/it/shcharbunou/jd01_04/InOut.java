package by.it.shcharbunou.jd01_04;

import java.util.Scanner;

public class InOut {

    protected static String getArrayLine(Scanner scanner) {
        boolean isCorrect;
        String line;
        System.out.println("Enter your array:");
        do {
            isCorrect = true;
            line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if (!(Character.isDigit(line.charAt(i))) && !(Character.isSpaceChar(line.charAt(i)))
                        && !(line.charAt(i) == '.') && !(line.charAt(i) == '-') && !(line.charAt(i) == '+')) {
                    System.out.println("Error: Array must be double type. Try again:");
                    isCorrect = false;
                    break;
                }
                if ((line.charAt(i) == '-') || (line.charAt(i) == '+')) {
                    if (!(Character.isDigit(line.charAt(i + 1)))) {
                        System.out.println("Error: The sign must not be separated by a space. Try again:");
                        isCorrect = false;
                        break;
                    }
                }
            }
            if (line.equals("")) {
                isCorrect = false;
            }
        } while (!isCorrect);

        /*
        line = scanner.nextLine();
        while (!line.matches("[0-9]+ +")) {
            System.out.println("Error: Array must be double type. Try again:");
            line = scanner.nextLine();
        }
        */

        return line;
    }

    /**
     * a method that gets an array from an input string
     * @param line a string potentially containing an array
     * @return array of double type
     */
    protected static double[] getArray(String line) {
        line = line.trim();
        String[] stringsArray = line.split(" ");
        double[] preparedArray = new double[stringsArray.length];
        for (int i = 0; i < preparedArray.length; i++) {
            preparedArray[i] = Double.parseDouble(stringsArray[i]);
        }
        return preparedArray;
    }

    /**
     * method that prints the array
     * @param array array of double type
     */
    protected static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element + " ");
        }
        System.out.print("\n");
    }

    /**
     * a method that prints a formatted array
     * @param array array of double type
     * @param name name of array
     * @param columnsCount the number of columns that can be written in one line
     */
    protected static void printArray(double[] array, String name, int columnsCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, array[i]);
            if (((i + 1) % columnsCount == 0 || i == array.length - 1)) {
                System.out.print("\n");
            }
        }
    }

    protected static double[][] getMatrix(int rows, int columns, Scanner scanner) {
        double[][] matrix = new double[rows][columns];
        boolean isCorrect;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                do {
                    isCorrect = true;
                    System.out.println("Enter " + (i + 1) + " " + (j + 1) + " element:");
                    try {
                        matrix[i][j] = Double.parseDouble(scanner.next());
                    } catch (Exception e) {
                        System.out.println("Error: Value must be double type. Try again:");
                        isCorrect = false;
                    }
                } while (!isCorrect);
            }
        }
        return matrix;
    }

    protected static int getNumber(Scanner scanner) {
        boolean isCorrect;
        int value = 0;
        do {
            isCorrect = true;
            try {
                value = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Error: Value must be integer. Try again:");
                isCorrect = false;
            }
        } while (!isCorrect);
        return value;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] doubles : matrix) {
            for (double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
            System.out.print("\n");
        }
    }
}
