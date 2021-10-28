package by.it.shcharbunou.jd01_05;

public class TaskA {

    public static void main(String[] args) {
        firstTask();
        secondTask();
    }

    private static void firstTask() {
        double a = 756.13, x = 0.3, z;
        String variableName = "z = ";
        z = calculatePiecemealExpression(a, x);
        printAnswer(z, variableName);
        z = calculateFullExpression(a, x);
        printAnswer(z, variableName);
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

    private static void printAnswer(double answer, String name) {
        System.out.println(name + answer);
    }

    private static void secondTask() {
        double a = 1.21, b = 0.371, y;
        String variableName = "y = ";
        y = calculateFunction(a, b);
        printAnswer(y, variableName);
    }

    private static double calculateFunction(double a, double b) {
        double temporaryValue;
        temporaryValue = Math.tan(Math.pow(a + b, 2)) - Math.pow(a + 1.5, (double) 1 / 3) + (a * Math.pow(b, 5)) -
                (b / Math.log(Math.pow(a, 2)));
        return temporaryValue;
    }
}
