package by.it.karmyzov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> stringsClass = Class.forName("java.lang.String");
        Method[] methods = stringsClass.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                System.out.println(method.getName()); }

        }
    }
}
