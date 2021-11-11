package by.it.rudakova.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }
        catch (NullPointerException | NumberFormatException e){
            Class<TaskA> taskAClass = TaskA.class;
            StackTraceElement[] stackTrace = e.getStackTrace();
            for(StackTraceElement stackTraceElement:stackTrace){
                String className=stackTraceElement.getClassName();
                if(className.equals(taskAClass.getName())){
                   Class<? extends RuntimeException> eClass = e.getClass();
                    String classNameException=eClass.getName();
                    int lineNumber=stackTraceElement.getLineNumber();
                    System.out.printf(""+" name:%s%n"+"class:%s%n"+" line:%s%n", classNameException,className,lineNumber);
                    break;
                }
            }
        }
    }
}
