package by.it.karpovich.jd01_15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

public class TaskA {

    static final String MATRIX_TXT = "matrix.txt";
    static final Random random = new Random();


    public static void main(String[] args) {
        int[][] matrix = new int[6][4];
        fill(matrix);
        String filePath = PathCreator.getFileName(TaskA.class, MATRIX_TXT);
        printMatrixToFile(matrix, filePath);
        readMatrixToConsole(filePath);
    }

    private static void readMatrixToConsole(String filePath) {
        try {
            Stream<String> lines = Files.lines(Paths.get(filePath));
            lines.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printMatrixToFile(int[][] matrix, String fileName) {
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            for (int[] row : matrix) {
                for (int anInt : row) {
                    printWriter.printf("%3d ", anInt);
                }
                printWriter.println();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printMatrixToConsole(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%3d ", anInt);
            }
            System.out.println();
        }
    }

    private static void fill(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                row[i] = random.nextInt(31) - 15;
            }
        }
    }


}