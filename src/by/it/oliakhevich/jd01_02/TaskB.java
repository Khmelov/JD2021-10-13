package by.it.oliakhevich.jd01_02;


import java.util.Random;
import java.util.Scanner;


public class TaskB {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Random random = new Random();
        int[] arr = new int[25];

        step1();
        int enterMonth = sc.nextInt();
        step2(enterMonth);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a, b, c);

    }

    private static void step1() {
        int counter = 1;
        int[][] array = new int[5][5];
        for (int a = 0; a < 5; a++) {
            System.out.println();
            for (int b = 0; b < 5; b++) {
                array[a][b] = counter++;
                System.out.print(array[a][b] + " ");

            }
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
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0)
            System.out.println("корней нет");
        else if (discriminant == 0) {
            double x = - b / (2 * a);
            System.out.println(x);

        } else {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(x1 + " " + x2);


        }



    }


}




