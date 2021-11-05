package by.it.karmyzov.jd01_10;

public class Bean {
    double sum(int left, int right) {
        return left + right;
    }

    @Param(a = 2, b = 5)
    static double min(int left, int right) {
        return Math.min(left, right);
    }

    @Param(a = 44, b = 55)
    double max(int left, int right) {
        return Math.max(left, right);
    }

    @Param(a = 2, b = 5)
    static double avg(int left, int right) {
        return (left + right) / 2.0;
    }
}
