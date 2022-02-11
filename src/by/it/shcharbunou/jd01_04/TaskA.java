package by.it.shcharbunou.jd01_04;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMulTable();
        String line = InOut.getArrayLine(scanner);
        buildOneDimArray(line);
    }

    private static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-3d", i, j, i * j);
            }
            System.out.print("\n");
        }
    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstElement = array[0];
        double lastElement = array[array.length - 1];
        final String ARRAY_NAME = "V";
        final int COLUMNS_COUNT = 5;
        InOut.printArray(array, ARRAY_NAME, COLUMNS_COUNT);
        Helper.sort(array);
        final int OUTPUT_COLUMNS_COUNT = 4;
        InOut.printArray(array, ARRAY_NAME, OUTPUT_COLUMNS_COUNT);
        boolean isFirstFound = false;
        boolean isLastFound = false;
        int firstIndex = 0;
        int lastIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstElement) {
                isFirstFound = true;
                firstIndex = i;
            }
            if (array[i] == lastElement) {
                isLastFound = true;
                lastIndex = i;
            }
            if (isFirstFound && isLastFound) {
                break;
            }
        }
        System.out.println("Index of first element=" + firstIndex);
        System.out.println("Index of last element=" + lastIndex);
    }
}
