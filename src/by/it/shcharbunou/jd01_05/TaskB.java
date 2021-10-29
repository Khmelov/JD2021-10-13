package by.it.shcharbunou.jd01_05;

public class TaskB {

    public static void main(String[] args) {
        firstTask();
        secondTask();
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

    private static void secondTask() {
        double a;
        for (double x = -5.5; x < 2; x += 0.5) {
            if ((x / 2 <= -1) && (x / 2 > -2)) {
                a = Math.log10(Math.abs(Math.sin(Math.pow(x, 2)) + 2.74));
                printFormatAnswerSecondTask(x, a);
            } else if ((x / 2 < 0.2) && (x / 2 > -1)) {
                a = Math.log10(Math.abs(Math.cos(Math.pow(x, 2)) + 2.74));
                printFormatAnswerSecondTask(x, a);
            } else if (x / 2 == 0.2) {
                a = Math.log10(Math.abs(Math.cos(Math.pow(x, 2)) / Math.sin(Math.pow(x, 2)) + 2.74));
                printFormatAnswerSecondTask(x, a);
            } else {
                printError(x);
            }
        }
    }

    private static void printError(double x) {
        System.out.printf("When x / 2 = %5.2f no calculations possible!\n", x);
    }

    private static void printFormatAnswerSecondTask(double x, double a) {
        System.out.printf("When x / 2 = %-5.2f, a = %g\n", x, a);
    }
}
