package by.it.marukovich.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);


    }
    static void buildOneDimArray(String line){
        //1 2 3 4 5 6 7 8 9.99 0
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V",5);
        double first = array[0];
        double last = array[array.length - 1];
        Helper.sort(array);
        //0 1 2 3 4 5 6 7 8 9.99
        int indexFirst = binarySearch(array, first);
        int indexLast = binarySearch(array, last);
        System.out.printf("\nfirst element=%d", indexFirst);
        System.out.printf("\nlast element=%d", indexLast);
    }

    static int binarySearch(double[] array, double value){
        int mid = array.length / 2;
        if (value == array[mid]) {
            return mid;
        }

        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (value < array[mid]) {
                end = mid - 1;
            } else if (value > array[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }

}
