package by.it.marukovich.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер матрицы n");
        int n = scanner.nextInt();
        step1(n);

    }

    static int[][] step1(int n) {

        int[][] arr = new int[n][n];
        boolean isNegativeNHere = false;
        boolean isPositiveNHere = false;
        do {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = (int) (Math.random() * (n * 2 + 1)) - n;
                    if (arr[i][j] == -n) {
                        isNegativeNHere = true;
                    } else if (arr[i][j] == n) {
                        isPositiveNHere = true;
                    }

                }
            }
        }
        while (!(isNegativeNHere) && isPositiveNHere);


        return arr;
    }

}
