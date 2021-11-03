package by.it.marukovich.jd01_10;

public class Bean {

    int sum(int left, int right){
        return left + right;
    }
    @Param(a=4, b=5)
    int min(int left, int right){
        return Math.min(left, right);
    }
    @Param(a=44, b=55)
    int max(int left, int right){
        return Math.max(left, right);
    }
    @Param(a=4, b=5)
    int avg(int left, int right){
        return (left + right) / 2;
    }
}
