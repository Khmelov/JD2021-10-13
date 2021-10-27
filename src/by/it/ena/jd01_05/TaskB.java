package by.it.ena.jd01_05;

import static java.lang.Math.*;


public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double sum = 0;
        for (double a = 0; a <= 2.0; a += 0.2) {
            sum = pow(7, a) * 6;
            for (int k = 1; k <= 6; ++k)
                sum -= cos(k);
        }
        System.out.println(sum);
    }

    private static void step2() {
        double b;
        for (double x = -6; x <2 ; x+=0.5) {
            if(x/2>-2 && x/2<=-1){
                b=sin(x*x);
            }
            else if(x/2>-1 && x/2<0.2){
                b=cos(x*x);
            }
            else if(x/2==0.2){
                b=1/tan(x*x);
            }
            else continue;
            double a=Math.log10(abs(b+2.74));
            System.out.format("При x/2=%-1.2f   a=%E",x,a);
            System.out.println();
        }
    }

}
