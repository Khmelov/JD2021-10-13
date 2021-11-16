package by.it.malyshchik.jd01_13;

import java.util.HashMap;
//программно обработайте исключения: определите и выведите в консоль
//имя исключения, имя класса, номер строки класса TaskA в которой это исключение возникло.
//формат вывода name: java.lang.NullPointerException
//class: by.it.вашпакет.jd01_13.TaskA
//line: 8
// никаких других данных выводиться не должно.
public class TaskA {
    public static void main(String[] args) {
        try{
        if (Math.random() > 0.5)
            new HashMap<String, String>(null);
        else
            Integer.parseInt("привет");
    }
    catch (Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            if (TaskA.class.getName().equals(element.getClassName())) {
                System.out.println(element);
            String name = e.getClass().getName();
            String className = element.getClassName();
            int lineNumber = element.getLineNumber();
                System.out.printf(
                        " name: %s\n" +
                        "class: %s\n" +
                        " line: %d\n",
                        name,className,lineNumber);
                break;
            }
        }
    }
    }
}