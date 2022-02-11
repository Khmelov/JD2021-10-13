package by.it.antipov.jd01_13;

import java.util.Objects;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        for (; ; )
            try {
                String Text = scanner.nextLine();
                if (!Objects.equals(Text, "END")) {
                    double a = Double.parseDouble(Text);
                    sum = sum + a;
                    System.out.println(sum);
                    double sqrt =  Math.sqrt(sum);
                   if (Double.isNaN(sqrt)){throw new ArithmeticException();}
                     else System.out.println(sqrt);
                } else break;
            } catch (NumberFormatException | ArithmeticException e) {
                String exceptionClass = e.getClass().getName();
                Class<?> taskBClass = TaskB.class;
                String nameA = taskBClass.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                int lineNumber = 0;
                for (StackTraceElement element : stackTrace) {
                    if (element.getClassName().equals(taskBClass.getName())) {
                        lineNumber = element.getLineNumber();

                    }
                }
                System.out.printf("name: %1$s%nclass: %2$s%nline: %3$d%n ", exceptionClass, nameA, lineNumber);
            }
    }
}