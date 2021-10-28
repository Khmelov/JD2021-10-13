package by.it.shcharbunou.jd01_05;

public class TaskA {

    public static void main(String[] args) {
        firstTask();
    }

    private static void firstTask() {
        double a = 756.13, x = 0.3, z;
        z = calculatePiecemealExpression(a, x);
        printAnswer(z);
        z = calculateFullExpression(a, x);
        printAnswer(z);
    }

    private static double calculatePiecemealExpression(double a, double x) {
        double temporaryValue;
        temporaryValue = Math.cos(Math.pow(Math.pow(x, 2) + Math.PI / 6, 5));
        temporaryValue -= Math.sqrt(x * Math.pow(a, 3));
        temporaryValue -= Math.log(Math.abs((a - 1.12 * x) / 4));
        return temporaryValue;
    }

    private static double calculateFullExpression(double a, double x) {
        double temporaryValue;
        temporaryValue = Math.cos(Math.pow(Math.pow(x, 2) + Math.PI / 6, 5)) - Math.sqrt(x * Math.pow(a, 3)) -
                Math.log(Math.abs((a - 1.12 * x) / 4));
        return temporaryValue;
    }

    private static void printAnswer(double answer) {
        System.out.println("answer = " + answer);
    }
}
