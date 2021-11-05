package by.it.malyshchik.jd01_10;

public class Bean {
    @Param(a=4, b=8)
    static double sum (int a, int b){
        return a+b;
    }
    @Param(a=4, b=8)
    static double max (int a, int b){
        return Math.max(a, b);
    }
    @Param(a=4, b=8)
    double min (int a, int b){
        return Math.min(a, b);
    }
    double avg (int a, int b){
        return (a+b)/2.0;
    }
}
