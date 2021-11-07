package by.it.antipov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        StringBuilder out = new StringBuilder();
        Class<String> stringClass = String.class;
        for (Method method:stringClass.getDeclaredMethods()) {
            int modifiers = method.getModifiers();
            if (Modifier.isStatic(modifiers)) {continue;}
            else {
                String name = method.getName();
                System.out.println(name+" ");
            }
        }

    }

}
