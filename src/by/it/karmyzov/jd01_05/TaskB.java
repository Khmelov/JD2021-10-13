package by.it.karmyzov.jd01_05;

import static java.lang.Math.*;


public class TaskB {
    public static void main(String[] args) {
        double sum = 0;
        for (double a = 0; a <= 2; a = a + 0.2) {
            System.out.println(sum);
            for (double x = 1; x <= 6; x++) {
                sum = sum + (pow(7, a) - cos(x));
            }
        }
    }
}