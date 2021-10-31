package by.it.malyshchik.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step2() {
        for (double x = -6; x < 2; x = x + 0.5) {
            if (x / 2 > -2 && x / 2 <= -1) {
                double b = sin(pow(x, 2));
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%3.2f a=%f\n", x / 2, a);
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                double b = cos(pow(x, 2));
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%3.2f a=%f\n", x / 2, a);
            } else if
            (x / 2 == 0.2) {
                double b = cos(pow(x, 2)) / sin(pow(x, 2));
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%3.2f a=%f\n", x / 2, a);
            } else if (x / 2 <= -2 || x / 2 > 0.2) {
                System.out.printf("При x/2=%3.2f результат не определен \n", x / 2);
            }
        }
    }

        private static void step1 () {
//        double y;
//        double a;
            double sum = 0;
            for (double a = 0; a <= 2; a = a + 0.2) {
                for (int x = 1; x <= 6; x++) {
                    double y = pow(7, a) - cos(x);
                    sum = sum + y;
                    System.out.println(sum);
                }

            }
        }
    }
