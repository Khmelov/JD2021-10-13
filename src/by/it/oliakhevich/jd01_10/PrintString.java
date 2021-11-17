package by.it.oliakhevich.jd01_10;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args)  {
        Class<String> stringClass = String.class;
        Method[] Methods = stringClass.getDeclaredMethods();
        for (Method Method : Methods) {
            int modifiers = Method.getModifiers();
            if (Modifier.isStatic(modifiers)) {
            } else {
                System.out.println(Method.getName());
            }

        }


    }


}
