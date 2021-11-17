package by.it.antipov.jd01_13;

import java.text.ParseException;
import java.util.HashMap;

public class TaskA {
    public void  describeEx(RuntimeException e) {}
    public static void main(String[] args) { try {
        if (Math.random()>0.5) new HashMap<String,String>(null);
        else Integer.parseInt("привет");
    } catch (NullPointerException|NumberFormatException e){
        String exceptionClass = e.getClass().getName();
        Class<?> taskAClass = TaskA.class;
        String nameA = taskAClass.getName();
        StackTraceElement[] stackTrace = e.getStackTrace();
        int lineNumber = 0;
        for (StackTraceElement element:stackTrace) {
           if (element.getClassName().equals(taskAClass.getName())){
               lineNumber = element.getLineNumber();
               System.out.printf("name: %1$s%nclass: %2$s%nline: %3$d%n ",exceptionClass,nameA,lineNumber);
           }
        }

    }

    }

}
