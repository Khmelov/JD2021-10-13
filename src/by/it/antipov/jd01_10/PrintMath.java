package by.it.antipov.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;

        for (Method method:mathClass.getDeclaredMethods()) {
            int modifiers = method.getModifiers();
            StringBuilder out = new StringBuilder();
            if (Modifier.isPublic(modifiers)){
                System.out.print("public ");
            } else continue;
            if (Modifier.isPrivate(modifiers)) {
                out.append("private ");
            }
            if (Modifier.isProtected(modifiers)) {
                out.append("protected ");
            }
            if (Modifier.isStatic(modifiers)) {
                out.append("static ");
            }
            Class<?> returnType = method.getReturnType();
            String simpleName = returnType.getSimpleName();
out.append(simpleName+" ");
out.append(method.getName());
out.append("(");
String delimeter ="";
            for (Class<?> type:method.getParameterTypes()) {
                out.append(delimeter);
out.append(type.getSimpleName());
delimeter=",";
            }
            out.append(")");
            System.out.print(out);
            System.out.println();

        }
        StringBuilder out1 = new StringBuilder();
        for (Field fields:mathClass.getDeclaredFields()) {
            int modifiers = fields.getModifiers();
            if (Modifier.isPublic(modifiers)){
               System.out.print("public ");
            } else continue;
            Class<?> type = fields.getType();
out1.append(type.getSimpleName()+" ");
out1.append(fields.getName()+" ");
out1.append("\n");
        }
        System.out.println(out1);

    }
}
