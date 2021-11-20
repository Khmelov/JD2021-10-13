package by.it.oliakhevich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step4();
        step5();
    }

    private static void step4() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            double y = 0;
            for (double x = 1; x <= 6; x++) {
                y = ((pow(7, a) - cos(x))) + y;
            }
            System.out.printf("При a=%6.2f y=%g\n", a, y);
        }
    }

    private static void step5() {
        double a;
        double b;
        for (double x = -6; x < 2; x = x + 0.5) {
            if (x / 2 > -2 && x / 2 <= -1) {
                b = sin(x * x);
                a = log10(abs(b + 2.74));
                System.out.print("При x/2="+(x/2));
                System.out.println("   a="+a);
            }
            else if (x / 2 > -1 && x / 2 < 0.2) {
                b = sin(x * x);
                a = log10(abs(b + 2.74));
                System.out.print("При x/2="+(x/2));
                System.out.println("   a="+a);
            }
            else if (x / 2 ==0.2) {
                b = sin(x * x);
                a = log10(abs(b + 2.74));
                System.out.print("При x/2="+(x/2));
                System.out.println("   a="+a);
            }


        }


    }

}

