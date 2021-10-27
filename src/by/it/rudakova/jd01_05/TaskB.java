package by.it.rudakova.jd01_05;
import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        System.out.println();
        step2();

    }

    private  static void step1(){
        double y=0;
        for(double a=0;a<=2;a=a+0.2){
            for(int x=1;x<=6;x++){
                y=y+(pow(7,a)-cos(x));
                System.out.printf("При а=%g Сумма y=%g\n",a,y);
            }
        }

    }
    private static void step2(){
        double a=0;
        for(double x=-5.5;x<2;x=x+0.5){
            if(x/2>-2 && x/2<=-1){
                a=log10(abs(sin(pow(x,2))+2.74));
                System.out.printf("При x/2=%-1.2f a=%e\n",x/2,a);
            }
           else if(x/2>-1 && x/2<0.2){
                a=log10(abs(cos(pow(x,2))+2.74));
                System.out.printf("При x/2=%-1.2f a=%e\n",x/2,a);
            }
           else if(x/2==0.2){
                a=log10(abs(cos(pow(x,2))/sin(pow(x,2))+2.74));
                System.out.printf("При x/2=%-1.2f a=%e\n",x/2,a);
            }
           else {
                System.out.printf("При x/2=%-1.2f вычисления не определены\n",x/2);
            }
        }

    }
}
