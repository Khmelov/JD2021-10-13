package by.it.shcharbunou.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] stringMethods = stringClass.getDeclaredMethods();
        printNonStaticStringMethodsName(stringMethods);
    }

    private static void printNonStaticStringMethodsName(Method[] stringMethods) {
        for (Method stringMethod : stringMethods) {
            if ((stringMethod.getModifiers() & Modifier.STATIC) != Modifier.STATIC) {
                System.out.println(stringMethod.getName());
            }
        }
    }
}
