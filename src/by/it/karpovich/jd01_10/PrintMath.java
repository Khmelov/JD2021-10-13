package by.it.karpovich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods =  mathClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder out = new StringBuilder();
            int modifiers = method.getModifiers();

            if (Modifier.isPublic(modifiers)) {
                System.out.println("Public");
            }

            if (Modifier.isPrivate(modifiers)) {
                System.out.println("Private");
            }

            if (Modifier.isStatic(modifiers)) {
                System.out.println("Static");
            }

            if (Modifier.isProtected(modifiers)) {
                System.out.println("Protected");
            }
           // else continue;
            Class<?> returnType = method.getReturnType();
            String returnClassName = returnType.getSimpleName();
            out.append(returnClassName).append(" ");
            String methodName = method.getName();
            out.append(methodName).append("{");

          Class <?>[] types = method.getParameterTypes();
          String delimiter = " ";


            System.out.println(out);
        }
    }
}
