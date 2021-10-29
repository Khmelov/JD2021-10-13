package by.it.shcharbunou.jd01_02;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect;
        int n = 0;
        System.out.println("Enter matrix order:");
        do {
            isCorrect = true;
            try {
                n = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Error: Value must be integer. Try again:");
                isCorrect = false;
            }
        } while (!isCorrect);
        int[][] arr = step1(n);
        int amount = step2(arr);
        int[][] updatedMatrix = step3(arr);
    }

    private static int[][] step1(int n) {
        int[][] matrix = new int[n][n];
        Random random = new Random();
        boolean isPositiveNCorrect, isNegativeNCorrect;
        do {
            isNegativeNCorrect = false;
            isPositiveNCorrect = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = random.nextInt(2 * n + 1) - n;
                    if (matrix[i][j] == n) {
                        isPositiveNCorrect = true;
                    } else if (matrix[i][j] == -n) {
                        isNegativeNCorrect = true;
                    }
                }
            }
        } while (!(isNegativeNCorrect && isPositiveNCorrect));
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }
        return matrix;
    }

    private static int step2(int[][] arr) {
        int amount = 0;
        boolean isPositive;
        for (int[] ints : arr) {
            isPositive = false;
            for (int j = 0; j < ints.length - 1; j++) {
                if (ints[j] > 0) {
                    isPositive = true;
                }
                if (isPositive) {
                    if (!(ints[j + 1] > 0)) {
                        amount += ints[j + 1];
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(amount);
        return amount;
    }

    private static int[][] step3(int[][] arr) {
        ArrayList<Integer> lineIndexes = new ArrayList<>();
        ArrayList<Integer> columnIndexes = new ArrayList<>();
        int maxElement = Integer.MIN_VALUE;

        for (int[] ints : arr) {
            for (int anInt : ints) {
                maxElement = Math.max(maxElement, anInt);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == maxElement) {
                    if (!lineIndexes.contains(i)) {
                        lineIndexes.add(i);
                    }
                    if (!columnIndexes.contains(j)) {
                        columnIndexes.add(j);
                    }
                }
            }
        }

        int[][] updatedMatrix = new int[arr.length - lineIndexes.size()][arr.length - columnIndexes.size()];
        int updatedLinesCounter = 0;
        int updatedColumnsCounter = 0;
        boolean isBreaked;
        for (int i = 0; i < arr.length; i++) {
            isBreaked = false;
            for (int j = 0; j < arr[i].length; j++) {
                if (lineIndexes.contains(i)) {
                    lineIndexes.remove(0);
                    isBreaked = true;
                    break;
                } else if (!columnIndexes.contains(j)) {
                    updatedMatrix[updatedLinesCounter][updatedColumnsCounter] = arr[i][j];
                    updatedColumnsCounter++;
                }
            }
            updatedColumnsCounter = 0;
            if (!isBreaked) {
                updatedLinesCounter++;
            }
        }

        for (int[] ints : updatedMatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }

        return updatedMatrix;
    }
}
