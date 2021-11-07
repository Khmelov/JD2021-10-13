package by.it.antipov.jd01_10;

public class Bean {

    @Param (a=15 , b=16)
    public static double sum(int first, int second){
        return first+second;
    }
    @Param (a=13 , b=11)
    public static double max(int first, int second){
        return Math.max(first,second);
    }
    @Param (a=10 , b=14)
    public  double min(int first, int second){
        return Math.min(first,second);
    }

    public double avg(int first, int second){
        return (double)(first+second)/2;
    }

}
