package by.it.shcharbunou.jd01_13;

import java.util.HashMap;

@SuppressWarnings("all")
public class TaskA {

    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NumberFormatException | NullPointerException e) {
            printRuntimeException(e);
        }
    }

    static void printRuntimeException(RuntimeException e) {
        Class<by.it.shcharbunou.jd01_13.TaskA> taskAClass = by.it.shcharbunou.jd01_13.TaskA.class;
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            String currentClassName = stackTraceElement.getClassName();
            if (currentClassName.equals(taskAClass.getName())) {
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
