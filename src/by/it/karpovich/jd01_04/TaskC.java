package by.it.karpovich.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        buildOneDimArray(s);
    }

    static void buildOneDimArray(String line) {
        //1 2 3 4 5 6 7 8 9.99 0
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array);
        //0 1 2 3 4 5 6 7 8 9.99
        InOut.printArray(array, "V", 4);

        int indexFirstElement = binarySearch(array, first);
        System.out.printf("Index of first element=%d\n", indexFirstElement);


        for (int i = 0; i < array.length; i++) {
            if (last == array[i]) {
                System.out.printf("Index of last element=%d\n", i);
                break;
            }
        }


    }

    private static int binarySearch(double[] array, double element) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int centre = (left + right) / 2;
            if (array[centre] == element) {
                return centre;
            } else if (array[centre] > element) {
                right = centre - 1;
            } else {
                left = centre + 1;
            }
        }
        return -1;
    }

    public static void mergeSort(double[] array) {
        if (array.length < 2) {
            return;
        }
        int mid = array.length / 2;
        double[] left = Arrays.copyOfRange(array, 0, mid);
        double[] right = Arrays.copyOfRange(array, mid, array.length);
        mergeSort(left);
        mergeSort(right);
        double[] result = merge(left, right);
        System.arraycopy(result, 0, array, 0, array.length);
    }

    private static double[] merge(double[] left, double[] right) {
        int indexLeft = 0;
        int indexRight = 0;
        double[] result = new double[left.length + right.length];
        for (int i = 0; i < result.length; i++) {
            if (indexRight == right.length || (indexLeft < left.length && left[indexLeft] < right[indexRight])) {
                result[i] = left[indexLeft++];
            } else {
                result[i] = right[indexRight++];
            }
        }
        return result;
    }
}
