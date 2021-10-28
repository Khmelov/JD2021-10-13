package by.it.shcharbunou.jd01_05;

public class TaskB {

    public static void main(String[] args) {
        firstTask();
    }

    private static void firstTask() {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (int x = 1; x < 7; x++) {
                y += Math.pow(7, a) - Math.cos(x);
                printFormatAnswer(a, y);
            }
        }
    }

    private static void printFormatAnswer(double a, double y) {
        System.out.printf("When a = %-3.2f, y = %g\n", a, y);
    }
}
