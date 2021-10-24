package by.it.oliakhevich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {

        step3();
        step4();


    }

    private static void step3() {

        for (double a = 0; a <= 2; a = a + 0.2) {
            // for (int x = 1; x <= 6; x++) {
            double y = (pow(7, a)); //- cos(a));
            System.out.printf("При а=%-4s y=%-9s\n", a, y);
        }


    }


    private static void step4() {

        for (double x = -6; x <= 2; x = x + 0.5) {
            double a = log10(abs(sin(x) + 2.74));

            if (x / 2 > -2 && x / 2 <= -1) {
                a = log10(abs(sin(pow((x / 2), 2)) + 2.74));
                System.out.printf("При x/2 =%-1.2f a=%e\n", x / 2, a);
            }

            if (x / 2 > -1 && x / 2 < 0.2) {
                a = log10(abs(cos(pow((x / 2), 2)) + 2.74));
                System.out.printf("При x/2=%-1.2f a=%e\n", x / 2, a);
            }
            if (x / 2 == 0.2) {
                a = log10(abs(tan(pow((x / 2), 2)) + 2.74));
                System.out.printf("При x/2=%-1.2f a=%e\n", x / 2, a);
            }
            if ( x/2 < -2 && x/2 >0.2 ) {
                System.out.printf("При x/2=%-1.2f a=%25b\n", x / 2, "вычисления не определены");


            }


        }
    }
}

