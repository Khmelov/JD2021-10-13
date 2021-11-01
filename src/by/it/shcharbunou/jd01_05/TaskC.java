package by.it.shcharbunou.jd01_05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TaskC {

    public static void main(String[] args) {
        firstTask();
        secondTask();
    }

    private static void secondTask() {
        int[] arrayA = new int[31];
        fillArrayA(arrayA);
        ArrayList<Integer> arrayB = new ArrayList<>();
        fillArrayB(arrayA, arrayB);
        Collections.sort(arrayB);
        printPseudoArrays(arrayA, arrayB);
    }

    private static void printPseudoArrays(int[] arrayA, ArrayList<Integer> arrayB) {
        char rightBottom = '╝';
        char rightTop = '╗';
        char leftBottom = '╚';
        char leftTop = '╔';
        char leftMiddle = '╠';
        char rightMiddle = '╣';
        char topMiddle = '╦';
        char bottomMiddle = '╩';
        char middle = '╬';
        char horizontal = '═';
        char vertical = '║';
        String topBorderArrayA = "╔═══════════╦═══════════╦═══════════╦═══════════╦═══════════╗";
        String middleBorderArrayA = "╠═══════════╬═══════════╬═══════════╬═══════════╬═══════════╣";
        String bottomBorderArrayA = "╚═══════════╩═══════════╩═══════════╩═══════════╩═══════════╝";
        System.out.println("Array A:");
        System.out.println(topBorderArrayA);
        for (int i = 0; i < arrayA.length; i++) {
            System.out.printf("%c A[%2d]=%3d ", vertical, i, arrayA[i]);
            if ((i + 1) % 5 == 0) {
                if (i != arrayA.length - 1) {
                    System.out.println(vertical);
                    System.out.println(middleBorderArrayA);
                } else {
                    System.out.println(vertical);
                    System.out.println(bottomBorderArrayA);
                }
            }
            if ((i == arrayA.length - 1) && ((i + 1) % 5 != 0)) {
                int temporaryAggregate = i;
                while ((temporaryAggregate + 1) % 5 != 0) {
                    System.out.printf("%c           ", vertical);
                    temporaryAggregate++;
                }
                System.out.println(vertical);
                System.out.println(bottomBorderArrayA);
            }
        }
        String topBorderArrayB = "╔═══════════╦═══════════╗";
        String middleBorderArrayB = "╠═══════════╬═══════════╣";
        String bottomBorderArrayB = "╚═══════════╩═══════════╝";
        System.out.println("Array B:");
        System.out.println(topBorderArrayB);
        for (int i = 0, j = arrayB.size() / 2; i < arrayB.size() / 2; i++, j++) {
            System.out.printf("%c B[%2d]=%3d ", vertical, i, arrayB.get(i));
            System.out.printf("%c B[%2d]=%3d ", vertical, j, arrayB.get(j));
            System.out.println(vertical);
            if (i != arrayB.size() / 2 - 1) {
                System.out.println(middleBorderArrayB);
            } else {
                System.out.println(bottomBorderArrayB);
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
        final int MAX_VALUE = 450;
        final int MIN_VALUE = 103;
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = random.nextInt(MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE;
        }
    }

    private static void firstTask() {
        Random random = new Random();
        final int MAX_LENGTH = 40;
        final int MIN_LENGTH = 20;
        double[] array = new double[random.nextInt(MAX_LENGTH - MIN_LENGTH + 1) + MIN_LENGTH];
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
            System.out.printf("Array[%d] = %g\t", i, array[i]);
            if ((i + 1) % 5 == 0) {
                System.out.print("\n");
            }
        }
        System.out.print("\n");
    }

    private static void fillArray(double[] array) {
        final double MIN_X = 5.33;
        final double MAX_X = 9;
        final double DIFFERENCE = MAX_X - MIN_X;
        final double DELTA_X = DIFFERENCE / array.length;
        double x = MIN_X;

        for (int i = 0; i < array.length; i++) {
            array[i] = getValue(x);
            x += DELTA_X;
        }
    }

    private static double getValue(double x) {
        return Math.cbrt(Math.pow(x, 2) + 4.5);
    }
}
