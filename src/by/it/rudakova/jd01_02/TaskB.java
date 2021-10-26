package by.it.rudakova.jd01_02;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        System.out.println("Матрица 5 на 5: ");

        step1();

        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер месяца: ");
        int inputNumberMonth = scanner.nextInt();

        step2(inputNumberMonth);

        System.out.println();

        System.out.println("Введите параметры a b c");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        System.out.println();

        step3(a, b, c);


    }


    private static void step1() {
        int[][] myArray = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 5; k++) {
                System.out.print(myArray[i][k] + " ");
            }

            System.out.println();
        }
    }


    private static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }
    }


    private static void step3(double a, double b, double c) {
        double disc = (double) (b * b - 4 * a * c);
        if (disc > 0) {
            double firstRoot = (-b + Math.sqrt(disc)) / (2 * a);
            double secondRoot = (-b - Math.sqrt(disc)) / (2 * a);
            System.out.println("Уравнение имеет 2 корня: " + firstRoot + ", " + secondRoot);
        } else if (disc == 0) {
            double onlyOneRoot = -b / (2 * a);
            System.out.println("Уравнение имеет 1 корень: " + onlyOneRoot);
        } else if (disc < 0) {
            System.out.println("корней нет");

        }
    }
}






