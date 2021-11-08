package by.it.shcharbunou.jd01_10;

public class Bean {

    @Param(a = 3, b = 4)
    protected static double max(int a, int b) {
        return Math.max(a, b);
    }

    @Param(a = 123, b = -895)
    protected static double min(int a, int b) {
        return Math.min(a, b);
    }

    @Param(a = 10100, b = 1)
    protected double sum(int a, int b) {
        return a + b;
    }

    protected double avg(int a, int b) {
        return (double) (a + b) / 2;
    }
}
