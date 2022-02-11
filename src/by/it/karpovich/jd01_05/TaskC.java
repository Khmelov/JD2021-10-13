package by.it.karpovich.jd01_05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static by.it.karpovich.jd01_05.Patterns.*;


public class TaskC {

    public static void main(String[] args) {
        step6();
        step7();
    }
    // ___________________________________________________________________________________________________________ //

    private static void step6() {
        Random random = new Random();
        double[] array = new double[random.nextInt(ELEMENT_LENGTH_MAX - ELEMENT_LENGTH_MIN + 1) + ELEMENT_LENGTH_MIN];
        fillArray(array);
        printArray(array);
        ArrayList<Double> redoneArray = new ArrayList<>();
        fillRedoneArray(array, redoneArray);
        double average = findAverage(redoneArray);
        printAverage(average);
    }

    private static void printAverage(double average) {
        System.out.println("Average: " + average);
    }

    private static double findAverage(ArrayList<Double> redoneArray) {
        double productValue = 1;
        for (Double value : redoneArray) {
            productValue *= value;
        }
        return Math.pow(productValue, (double) 1 / redoneArray.size());
    }

    private static void fillRedoneArray(double[] array, ArrayList<Double> redoneArray) {
        for (double value : array) {
            if (value > 3.5) {
                redoneArray.add(value);
            }
        }
    }

    private static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf(PRINT_ARRAY_I, i, array[i]);
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void fillArray(double[] array) {
        final double DIFFERENCE_X = VALUE_X_MAX - VALUE_X_MIN;
        final double DELTA_X = DIFFERENCE_X / array.length;
        double x = VALUE_X_MIN;

        for (int i = 0; i < array.length; i++) {
            array[i] = getValue(x);
            x += DELTA_X;
        }
    }

    private static double getValue(double x) {
        return Math.cbrt(Math.pow(x, 2) + 4.5);
    }

    // ___________________________________________________________________________________________________________ //

    private static void step7() {
        int[] arrayA = new int[31];
        fillArrayA(arrayA);
        ArrayList<Integer> arrayB = new ArrayList<>();
        fillArrayB(arrayA, arrayB);
        Collections.sort(arrayB);
        printPseudoArrays(arrayA, arrayB);
    }

    private static void printPseudoArrays(int[] arrayA, ArrayList<Integer> arrayB) {

        System.out.println("Array A:");
        System.out.println(TOP_BORDER_ARRAY_A);
        for (int i = 0; i < arrayA.length; i++) {
            System.out.printf(PRINT_VERTICAL_ARRAY_A, VERTICAL, i, arrayA[i]);
            if ((i + 1) % 5 == 0) {
                if (i != arrayA.length - 1) {
                    System.out.println(VERTICAL);
                    System.out.println(MIDDLE_BORDER_ARRAY_A);
                } else {
                    System.out.println(VERTICAL);
                    System.out.println(BOTTOM_BORDER_ARRAY_A);
                }
            }
            if ((i == arrayA.length - 1) && ((i + 1) % 5 != 0)) {
                int temporaryAggregate = i;
                while ((temporaryAggregate + 1) % 5 != 0) {
                    System.out.printf(LINE_INDENT, VERTICAL);
                    temporaryAggregate++;
                }
                System.out.println(VERTICAL);
                System.out.println(BOTTOM_BORDER_ARRAY_A);
            }
        }
        System.out.println("Array B:");
        System.out.println(TOP_BORDER_ARRAY_B);
        for (int i = 0, j = arrayB.size() / 2; i < arrayB.size() / 2; i++, j++) {
            System.out.printf(PRINT_VERTICAL_ARRAY_B, VERTICAL, i, arrayB.get(i));
            System.out.printf(PRINT_VERTICAL_ARRAY_B, VERTICAL, j, arrayB.get(j));
            System.out.println(VERTICAL);
            if (i != arrayB.size() / 2 - 1) {
                System.out.println(MIDDLE_BORDER_ARRAY_B);
            } else {
                System.out.println(BOTTOM_BORDER_ARRAY_B);
            }
        }
    }

    private static void fillArrayB(int[] arrayA, ArrayList<Integer> arrayB) {
        for (int i = 0; i < arrayA.length; i++) {
            if ((arrayA[i] * 0.1) > i) {
                arrayB.add(arrayA[i]);
            }
        }
    }

    private static void fillArrayA(int[] arrayA) {
        Random random = new Random();
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = random.nextInt(RANDOM_MAX_VALUE - RANDOM_MIN_VALUE + 1) + RANDOM_MIN_VALUE;
        }
    }
}
