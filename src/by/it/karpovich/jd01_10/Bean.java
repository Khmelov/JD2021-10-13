package by.it.karpovich.jd01_10;

public class Bean {

    @Param(a = 4, b = 7)
    static double max(int left, int right) {
        return Math.max(left, right);
    }

    @Param(a = 4, b = 7)
    static double min(int left, int right) {
        return Math.min(left, right);
    }

    double sum(int left, int right) {
        return left + right;
    }

    @Param(a = 4, b = 7)
    double avg(int left, int right) {
        return (left + right) / 2.0;
    }


}
