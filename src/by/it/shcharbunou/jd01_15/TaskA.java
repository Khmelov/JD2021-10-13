package by.it.shcharbunou.jd01_15;

import java.io.*;
import java.util.Random;

public class TaskA {

    public static void main(String[] args) {
        final int ROWS_COUNT = 6;
        final int COLUMNS_COUNT = 4;
        int[][] matrix = new int[ROWS_COUNT][COLUMNS_COUNT];
        fillMatrix(matrix);
        PathFinder pathFinder = new PathFinder();
        String stringPath = pathFinder.getStringPath(TaskA.class, "matrix.txt");
        outputMatrixFile(stringPath, matrix);
        outputMatrixConsoleFromFile(stringPath);
    }

    private static void outputMatrixConsoleFromFile(String stringPath) {
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(stringPath))) {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void outputMatrixFile(String stringPath, int[][] matrix) {
        try (PrintWriter printWriter = new PrintWriter(stringPath)) {
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    printWriter.printf("%3d ", anInt);
                }
                printWriter.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillMatrix(int[][] matrix) {
        Random random = new Random();
        final int MIN_INTEGER = -15;
        final int MAX_INTEGER = 15;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt((MAX_INTEGER - MIN_INTEGER + 1)) + MIN_INTEGER;
            }
        }
    }
}
