package by.it.karmyzov.jd01_13;

import java.util.Scanner;

public class TaskB {
    private static char[] value;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        while (true) {
            String value = scanner.nextLine();
            if (value.equals("END")) {
                break;
            }
            try {
                double valueDouble = Double.parseDouble(value);
                System.out.println(valueDouble);
                sum = sum + valueDouble;
                double sqrtSum = Math.sqrt(sum);
                System.out.println("корень: " + sqrtSum);
                if (sum < 0)
                    throw new ArithmeticException();
            } catch (NumberFormatException | ArithmeticException e) {
                Class<? extends Exception> exeptionType = e.getClass();
                String name = exeptionType.getName();
                Class<TaskB> nameofClass = TaskB.class;
                String nameOfClassInStackTrace = nameofClass.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    String className = element.getClassName();
                    if (className.equals(nameOfClassInStackTrace)) {
                        int lineNumber = element.getLineNumber();
                        System.out.printf(
                                " name: %s\n" +
                                "class: %s\n" +
                                " line: %d\n",
                                name, className, lineNumber);
                        break;
                    }
                }

            }
        }

    }
}

