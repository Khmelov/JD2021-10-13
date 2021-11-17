package by.it.karpovich.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {
        step4();
        step5();
    }

    private static void step4() { //задание 4

        for (double a = 0; a <= 2; a = a + 0.2) { // <-- наше условие
            double y = pow(7, a) - cos(1) + pow(7, a) - cos(2) + pow(7, a) - cos(3) + pow(7, a) - cos(4) + pow(7, a) - cos(5) + pow(7, a) - cos(6);
            System.out.printf("При a=%6.2f y=%g \n", a, y); // 6 позиций, 2 знака после запятой
        }

    }

    private static void step5() { // задание 5
        for (double x = -6; x < 2; x = x + 0.5) { // <-- наше условие
            double b = 0.0;
            if (-2 < x / 2 && x / 2 <= -1) b = sin(pow(x, 2));
            else if (-1 < x / 2 && x / 2 < 0.2) b = cos(pow(x, 2));
            else if (x / 2 == 0.2) b = 1 / (tan(pow(x, 2)));
            else System.out.println("Выход за пределы");
            //Не допустить b=0

            double a = log10(abs(b + 2.74));
            if (b != 0) System.out.println(a);
        }
    }


}
