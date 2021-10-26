package by.it.marukovich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a += 0.2) {
            double z = 0;
            for (int x = 1; x <= 6; x += 1) {

                z += pow(7, a) - cos(x);
            }
            System.out.printf("При а=%.2f Сумма y =%g\n", a, z);
        }
    }

    private static void step2() {
        double a;
        double b=0;
        for (double x=-5.5; x<2;x+=0.5){
            if (x/2>-2 && x/2<=-1){
                b=sin(pow(x,2));
                a=log10(abs(b+2.74));
                System.out.printf("При х/2=%.2f a = %g\n", x/2,a);
            }
            else if(x/2>-1 && x/2<0.2){
                b=cos(pow(x,2));
                a=log10(abs(b+2.74));
                System.out.printf("При х/2=%.2f a = %g\n", x/2,a);
            }
            else if(x/2==0.2){
                b=1.0/tan(pow(x,2));
                a=log10(abs(b+2.74));
                System.out.printf("При х/2=%.2f a = %g\n", x/2,a);
            }
            else {
                System.out.printf("При х/2=%.2f вычисления не определены\n", x/2);
            }


        }
    }
}
