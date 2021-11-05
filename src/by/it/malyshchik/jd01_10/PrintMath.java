package by.it.malyshchik.jd01_10;

import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    private static final String SPACE = " ";
    private static final String LEFT_BRACKET = "(";
    private static final String EMPTY_STRING = "";
    private static final String COMMA = ",";
    private static final String RIGHT_BRACKET = ")";

    public static void main(String[] args) {

        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();

        for (Method method : methods) {
            StringBuilder out = new StringBuilder();
            if (addModifiers(method, out)) continue;
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
        Field[] fields = mathClass.getDeclaredFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                StringBuilder fieldname = new StringBuilder();
                Class<?> type = field.getType();
                String name = field.getName();
                StringBuilder append = fieldname.append(type).append(SPACE).append(name);
                System.out.println(append);

            }
        }
    }


    private static boolean addModifiers(Method method, StringBuilder out) {

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


