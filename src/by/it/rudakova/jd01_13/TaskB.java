package by.it.rudakova.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String englishText;
        double number = 0;
        double sum = 0;

        while (true) {
            englishText = scanner.nextLine();
            if (englishText.equals("END")) {
                break;
            }
            try {
                number = Double.parseDouble(englishText);
                System.out.println("Введенное число:" + number);
            } catch (NullPointerException | NumberFormatException e) {
                Class<TaskB> taskBClass = TaskB.class;
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String className = stackTraceElement.getClassName();
                    if (className.equals(taskBClass.getName())) {
                        Class<? extends RuntimeException> eClass = e.getClass();
                        String classNameException = eClass.getName();
                        int lineNumber = stackTraceElement.getLineNumber();
                        System.out.printf("" + " name:%s%n" + "class:%s%n" + " line:%s%n", classNameException, className, lineNumber);
                        break;
                    }
                }
            }
            try {
                sum = sum + number;
                double sqrt = Math.sqrt(sum);
                if (Double.isNaN(sqrt)) {
                    throw new ArithmeticException();

                } else {
                    System.out.println("Корень из суммы всех введенных чисел: " + sqrt);
                }
            } catch (ArithmeticException e) {
                Class<TaskB> taskBClass = TaskB.class;
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String className = stackTraceElement.getClassName();
                    if (className.equals(taskBClass.getName())) {
                        Class<? extends RuntimeException> eClass = e.getClass();
                        String classNameException = eClass.getName();
                        int lineNumber = stackTraceElement.getLineNumber();
                        System.out.printf("" + " name:%s%n" + "class:%s%n" + " line:%s%n", classNameException, className, lineNumber);
                        break;
                    }
                }
            }
        }
    }
}
