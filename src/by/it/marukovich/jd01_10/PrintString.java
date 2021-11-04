package by.it.marukovich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder out = new StringBuilder();
            if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
            String methodName = method.getName();
            out.append(methodName);
            System.out.println(out);
        }
        }
    }

}
