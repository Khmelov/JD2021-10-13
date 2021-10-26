package by.it._classwork_.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }

    }

    static void buildOneDimArray(String line) {
        //1 2 3 4 5 6 7 8 9.99 0
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        Helper.sort(array);
        //0 1 2 3 4 5 6 7 8 9.99
        InOut.printArray(array, "V", 4);

        int indexFirstElement = Arrays.binarySearch(array, first);
        System.out.printf("Index of first element=%d\n", indexFirstElement);


        for (int i = 0; i < array.length; i++) {
            if (last == array[i]) {
                System.out.printf("Index of last element=%d\n", i);
                break;
            }
        }
    }


}
