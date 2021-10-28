package by.it.shcharbunou.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect;
        int month = 0;
        System.out.println("Input the number of month:");
        do {
            isCorrect = true;
            try {
                month = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Error: Value must be integer. Try again:");
                isCorrect = false;
            }
        } while (!isCorrect);
        step2(month);
        double a, b, c;
        a = b = c = 0;
        System.out.println("Enter odds.");
        do {
            System.out.println("Enter a odd:");
            isCorrect = true;
            try {
                a = Double.parseDouble(scanner.next());
            } catch (Exception e) {
                System.out.println("Error: Value must be double. Try again:");
                isCorrect = false;
            }
        } while (!isCorrect);
        do {
            System.out.println("Enter b odd:");
            isCorrect = true;
            try {
                b = Double.parseDouble(scanner.next());
            } catch (Exception e) {
                System.out.println("Error: Value must be double. Try again:");
                isCorrect = false;
            }
        } while (!isCorrect);
        do {
            System.out.println("Enter c odd:");
            isCorrect = true;
            try {
                c = Double.parseDouble(scanner.next());
            } catch (Exception e) {
                System.out.println("Error: Value must be double. Try again:");
                isCorrect = false;
            }
        } while (!isCorrect);
        step3(a, b, c);
    }

    private static void step1() {
        int[][] matrix = new int[5][5];
        int counter = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = counter++;
            }
        }
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }
    }

    private static void step2(int month) {
        switch (month) {
            case 1 -> System.out.println("январь");
            case 2 -> System.out.println("февраль");
            case 3 -> System.out.println("март");
            case 4 -> System.out.println("апрель");
            case 5 -> System.out.println("май");
            case 6 -> System.out.println("июнь");
            case 7 -> System.out.println("июль");
            case 8 -> System.out.println("август");
            case 9 -> System.out.println("сентябрь");
            case 10 -> System.out.println("октябрь");
            case 11 -> System.out.println("ноябрь");
            case 12 -> System.out.println("декабрь");
            default -> System.out.println("нет такого месяца");
        }
    }

    private static void step3(double a, double b, double c) {
        double disc = sqr(b) - 4 * a * c;
        if (disc > 0) {
            double x1 = (-b + Math.sqrt(disc)) / (2 * a);
            double x2 = (-b - Math.sqrt(disc)) / (2 * a);
            System.out.println(x1 + " " + x2);
        } else if (disc == 0) {
            double x = -b / (2 * a);
            System.out.println(x);
        } else {
            System.out.println("корней нет");
        }
    }

    private static double sqr(double value) {
        return value * value;
    }
}
