package by.it._classwork_.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static final String LEFT_BRACKET = "(";
    public static final String SPACE = " ";
    public static final String EMPTY_STRING = "";
    public static final String COMMA = ",";
    public static final String RIGHT_BRACKET = ")";

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder out = new StringBuilder();
            if (addMadifiers(method, out)) continue;
            Class<?> returnType = method.getReturnType();
            String returnClassName = returnType.getSimpleName();
            out.append(returnClassName).append(SPACE);
            String methodName = method.getName();
            out.append(methodName).append(LEFT_BRACKET);

            Class<?>[] types = method.getParameterTypes();
            String delimiter = EMPTY_STRING;
            for (Class<?> type : types) {
                out.append(delimiter).append(type.getSimpleName());
                delimiter = COMMA;
            }
            out.append(RIGHT_BRACKET);
            System.out.println(out);
        }
    }

    private static boolean addMadifiers(Method method, StringBuilder out) {
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
