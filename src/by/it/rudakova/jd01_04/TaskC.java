package by.it.rudakova.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        buildOneDimArray(inputString);
    }

    private static void buildOneDimArray(String line) {

        double[] arrayFromLine = InOut.getArray(line);
        double firstValueInUnsortedArray = arrayFromLine[0];
        double lastValueInUnsortedArray = arrayFromLine[arrayFromLine.length - 1];
        InOut.printArray(arrayFromLine, "V", 5);
        mergeSort(arrayFromLine);
        InOut.printArray(arrayFromLine, "V", 4);
        for (int i = 0; i < arrayFromLine.length; i++) {
            if (firstValueInUnsortedArray == arrayFromLine[i]) {
                System.out.println("Index of first element=" + i);
            }
            if (lastValueInUnsortedArray == arrayFromLine[i]) {
                System.out.println("Index of last element=" + i);
            }
        }
    }

    private static void mergeSort(double[] arrayFromLine) {
        if (arrayFromLine.length < 2) {
            return;
        }

        double[] part1 = getPart(arrayFromLine, 0, arrayFromLine.length / 2);
        double[] part2 = getPart(arrayFromLine, arrayFromLine.length / 2, arrayFromLine.length);

        mergeSort(part1);
        mergeSort(part2);

        double[] mergedArray = merge(part1, part2);

        for (int i = 0; i < arrayFromLine.length; i++) {
            arrayFromLine[i] = mergedArray[i];
        }
    }

    private static double[] getPart(double[] array, int left, int right) {

        double[] partedArray = new double[right - left];

        int k = 0;
        for (int i = left; i < right; i++) {
            partedArray[k] = array[i];
            k++;
        }
        return partedArray;
    }

    private static double[] merge(double[] part1, double[] part2) {
        double[] left = part1;
        double[] right = part2;
        double[] mergedArray = new double[left.length + right.length];
        int k = 0;
        for (int i = 0, l = 0, r = 0; i < mergedArray.length; i++) {
            if (l >= left.length) {
                mergedArray[i] = right[r];
                r++;
            } else if (r >= right.length) {
                mergedArray[i] = left[l];
                l++;
            } else if (left[l] < right[r]) {
                mergedArray[i] = left[l];
                l++;
            } else {
                mergedArray[i] = right[r];
                r++;
            }
        }
        return mergedArray;
    }

}
