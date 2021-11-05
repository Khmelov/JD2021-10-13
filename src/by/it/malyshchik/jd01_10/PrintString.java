package by.it.malyshchik.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> Stringclass = String.class;
        Method[] methods = Stringclass.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (Modifier.isStatic(modifiers)) {
            } else {
                String name = method.getName();
                System.out.println(name);
            }

        }

    }


}

