package by.it.shcharbunou.jd01_05;

import java.util.ArrayList;
import java.util.Random;

public class TaskC {

    public static void main(String[] args) {
        firstTask();
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
