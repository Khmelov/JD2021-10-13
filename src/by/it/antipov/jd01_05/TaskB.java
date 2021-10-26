package by.it.antipov.jd01_05;

public class TaskB {
    public static void main(String[] args) {
        calculation4();
System.out.println();
        double b=0;
        double a;
        for (double x = -6; x < 2; x = x + 0.5) {
            if (((x / 2) > -2) & ((x / 2) <= -1)) {
                b = Math.sin(x * x);a=Math.log10(Math.abs(b+2.74));System.out.print(" x/2="+(x/2));System.out.print(" "+a);System.out.println();
            }
            if (((x / 2) > -1) & ((x / 2) < 0.2)) {
                b = Math.cos(x * x);a=Math.log10(Math.abs(b+2.74));System.out.print(" x/2="+(x/2));System.out.print(" "+a);System.out.println();
            }
            if (x/2==0.2) {b=(Math.cos(x*x)/Math.sin(x*x));a=Math.log10(Math.abs(b+2.74));System.out.print(" x/2="+(x/2));System.out.print(" "+a);System.out.println();}

if (((x>-6) & (x<=-4)) | (x>0.4)) System.out.println("Не подходит к какому-либо условию");


        }
    }

    private static void calculation4() {
        double calc = 0;
        for (double a = 0; a <= 2; a = a + 0.2) {
            System.out.println(calc);
            for (double x = 1; x <= 6; x = x + 1) {
                calc = calc + (Math.pow(7, a) - Math.cos(x));
            }
        }
        ;
    }
}
