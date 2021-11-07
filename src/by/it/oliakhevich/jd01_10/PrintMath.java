package by.it.oliakhevich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structureMath = Math.class;
        Method[] methods = structureMath.getDeclaredMethods();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC);
            System.out.println(method);

        }


    }

}
