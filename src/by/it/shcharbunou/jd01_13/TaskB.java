package by.it.shcharbunou.jd01_13;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temporaryStringNumber;
        double value;
        double valuesAmount = 0;
        double sqrtValues;
        for (; ; ) {
            temporaryStringNumber = scanner.nextLine();
            if (temporaryStringNumber.equalsIgnoreCase("END")) {
                break;
            }
            try {
                value = Double.parseDouble(temporaryStringNumber);
                System.out.println(value);
                valuesAmount += value;
                sqrtValues = Math.sqrt(valuesAmount);
                if (Double.isNaN(sqrtValues)) {
                    throw new ArithmeticException();
                }
                System.out.println(sqrtValues);
            } catch (NumberFormatException | ArithmeticException e) {
                printRuntimeException(e);
            }
        }
    }

    private static void printRuntimeException(RuntimeException e) {
        Class<TaskB> taskBClass = TaskB.class;
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            String currentClassName = stackTraceElement.getClassName();
            if (currentClassName.equals(taskBClass.getName())) {
                Class<? extends RuntimeException> exceptionClass = e.getClass();
                String exceptionClassName = exceptionClass.getName();
                int lineNumber = stackTraceElement.getLineNumber();
                System.out.printf("" +
                                " name: %s%n" +
                                "class: %s%n" +
                                " line: %d%n",
                        exceptionClassName,
                        currentClassName,
                        lineNumber
                );
                break;
            }
        }
    }
}
