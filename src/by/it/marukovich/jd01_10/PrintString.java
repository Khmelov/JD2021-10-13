package by.it.marukovich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methods = stringClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder out = new StringBuilder();
            if (addModifaers(method, out)) continue;
            Class<?> returnType = method.getReturnType();
            String returnClassName = returnType.getSimpleName();
            out.append(returnClassName);
            String methodName = method.getName();
            out.append(methodName);
            System.out.println(out);
        }
    }
    private static boolean addModifaers(Method method, StringBuilder out) {
        int modifiers = method.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            out.append("public ");
        } else {
            return true;
        }
        if (Modifier.isPrivate(modifiers)) {
            out.append("private ");
        }
        if (Modifier.isProtected(modifiers)) {
            out.append("protected ");
        }
        if (Modifier.isStatic(modifiers)) {
            out.append("static ");
        }
        return false;
    }
}
