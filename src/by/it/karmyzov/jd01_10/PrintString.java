package by.it.karmyzov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> structString = String.class;
        Method[] methods = structString.getDeclaredMethods();
        for (Method method : methods) {
            //StringBuilder out = new StringBuilder();
            //int modifiers = method.getModifiers();
            if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC); {
                System.out.println(method); }

        }
    }
}
