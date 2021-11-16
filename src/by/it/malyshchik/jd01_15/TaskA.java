package by.it.malyshchik.jd01_15;

import by.it._classwork_.jd01_15.RepoMatrix;
import by.it._classwork_.jd01_15.RepoMatrixImpl;

import java.util.Random;

public class TaskA {
    public static final int MIN = -15;
    public static final int MAX = 15;

    public static void main(String[] args) {
        PathFinder pathFinderService = new PathFinderImpl();
        int[][] array = new int[6][4];
        fillArray(array, MIN, MAX);
        String filename = pathFinderService.getStringPath(TaskA.class,"matrix.txt");
        RepoMatrix repoMatrix = new RepoMatrixImpl(filename);
        repoMatrix.save(array);
        int[][] arrayAfterLoad = repoMatrix.load();
        printArray(arrayAfterLoad);
    }

    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.printf("%3d ", element);

            }
            System.out.println();
        }

    }

    private static void fillArray(int[][] array, int min, int max) {
        Random random = new Random();
        for (int[] row : array) {
            for (int i = 0; i < row.length; i++) {
                row[i] = min + random.nextInt(max-min+1);
            }

        }
    }
}
