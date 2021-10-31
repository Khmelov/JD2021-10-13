package by.it.antipov.jd01_05;

public class TaskA {
    public static void main(String[] args) {
        calculation1();
        calculation2();

        calculation3();

    }

    private static void calculation3() {
        double x=12.1;
        for (double a=-5;a<=12;a=a+3.75){
            double f=Math.pow(Math.exp(1),a*x)-3.45*a;
            System.out.println("a="+a+"   F="+f);}
    }


    private static void calculation2() {
        double a =1.21;
        double b=0.371;
        double part1 =Math.tan(Math.pow((a+b),2)) ;
        double part2 =-Math.cbrt(a+1.5) ;
        double part3 = a*Math.pow(b,5);
        double part4 = -b/(Math.log(a*a));
        double result1 = part1+part2+part3+part4;
        System.out.println(result1);
        double result2 =Math.tan(Math.pow((a+b),2))-Math.cbrt(a+1.5)+a*Math.pow(b,5)-b/(Math.log(a*a));
        System.out.println(result2);
    }

    static void calculation1() {
        double a =756.13;
        double x=0.3;
        double part1 = Math.cos(Math.pow((Math.pow(x,2)+Math.PI/6),5));
        double part2 = -(Math.sqrt(x*Math.pow(a,3)));
        double part3 = -(Math.log(Math.abs((a-1.12*x)/4)));
        double result1 = part1+part2+part3;
        System.out.println(result1);
        double result2 =Math.cos(Math.pow((Math.pow(x,2)+Math.PI/6),5))-(Math.sqrt(x*Math.pow(a,3)))-(Math.log(Math.abs((a-1.12*x)/4)));
        System.out.println(result2);
    }
}
