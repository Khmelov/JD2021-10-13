package by.it.antipov.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = "value";
        double[] vector = {1, 2, 3};
        double[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        double[][] left = {{1, 2, 3},{4, 5, 6}};

        double[][] right = {
                {1, 2},
                {3, 4},
                {5, 6}
        };
        Helper.multiply(left,vector);

    }
}