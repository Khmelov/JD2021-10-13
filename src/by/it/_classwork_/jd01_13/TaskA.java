package by.it._classwork_.jd01_13;

import java.util.HashMap;

public class TaskA {


    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {

            printRuntimeException(e);
        }
    }

    static void printRuntimeException(RuntimeException e) {
        Class<TaskA> taskAClass = TaskA.class;
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String currentClassName = stackTraceElement.getClassName();
            if (currentClassName.equals(taskAClass.getName())) {
                Class<? extends RuntimeException> exceptionClass = e.getClass();

                String classNameException = exceptionClass.getName();

                int lineNumber = stackTraceElement.getLineNumber();

                System.out.printf("" +
                                " name: %s%n" +
                                "class: %s%n" +
                                " line: %d%n",
                        classNameException,
                        currentClassName,
                        lineNumber
                );
                break;
            }
        }
    }
}
