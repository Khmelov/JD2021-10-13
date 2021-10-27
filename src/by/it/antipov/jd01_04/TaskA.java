package by.it.antipov.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        printMulTable();
       buildOneDimArray(line);
    }

    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            System.out.println();
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1$d*%2$d=%3$-2d ", i, j, i * j);

            }

        }
    }

    static void buildOneDimArray(String line) {
        line = line.trim();
        String[] strings = line.split(" ");
        double[] array = new double[strings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(strings[i]);
        }
        for (int j = 0; j < array.length; j++) {
            System.out.printf(" V[%1$-1d]=%2$-4.4f", j, array[j]);
            if ((j + 1) % 5 == 0 | j == array.length - 1) {
                System.out.println();
            }

        }
        double left=array[0];
        double right=array[array.length-1];
        for (int a = 0; a < array.length - 1; a++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i + 1] < array[i]) {
                    double buffer = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = buffer;
                }
            }
        }
        for (int j = 0; j < array.length; j++) {
            System.out.printf(" V[1$-1d]=%2$-4.4f", j, array[j]);
            if ((j + 1) % 4 == 0 | j == array.length - 1) {
                System.out.println();}
        }
        for (int i = 0; i < array.length ; i++) { if (array[i]==left) System.out.println("Index of first element="+i);
if (i==right) System.out.println("Index of last element="+i);
        }
    }

}