package by.it.ena.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text;
        double number = 0;
        double sum = 0;


        for (; ; ) {
            text = scanner.next();
            if (text.equals("END")) {
                break;
            }

            try {
                number = Double.parseDouble(text);
                System.out.println(number);

            } catch (Exception e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        System.out.println(element);
                        String name = e.getClass().getName();
                        String className = element.getClassName();
                        int numberLine = element.getLineNumber();
                        System.out.printf("" +
                                        " name: %s%n" +
                                        "class: %s%n" +
                                        " line: %d%n",
                                name, className, numberLine);
                        break;
                    }

                }
            }

            try {
                sum += number;
                double sqrt = Math.sqrt(sum);
                if (Double.isNaN(sqrt)) {
                    throw new ArithmeticException();

                } else {
                    System.out.println("Корень из суммы всех введенных чисел: " + sqrt);
                }

            } catch (ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        System.out.println(element);
                        String name = e.getClass().getName();
                        String className = element.getClassName();
                        int numberLine = element.getLineNumber();
                        System.out.printf("" +
                                        " name: %s%n" +
                                        "class: %s%n" +
                                        " line: %d%n",
                                name, className, numberLine);
                        break;
                    }

                }
            }

        }

    }
}