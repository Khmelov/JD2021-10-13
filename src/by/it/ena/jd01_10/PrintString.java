package by.it.ena.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> structString = String.class;
        Method[] methods = structString.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder out=new StringBuilder();
            int modifiers=method.getModifiers();
            if(Modifier.isStatic(modifiers)){
                continue;
            }
            String methodName=method.getName();
            out.append(methodName);

            System.out.println(out);
        }
    }
}
