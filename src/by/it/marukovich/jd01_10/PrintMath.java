package by.it.marukovich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static final String LEFT_BREKET = "(";
    public static final String SPACE = " ";
    public static final String EMPTY_STRING = "";

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method:methods){
            StringBuilder out = new StringBuilder();
            int modifiers = method.getModifiers();
            if(Modifier.isPublic(modifiers)){
                out.append("public ");
            }
            if(Modifier.isPrivate(modifiers)){
                out.append("private ");
            }
            if(Modifier.isProtected(modifiers)){
                out.append("protected ");
            }
            if(Modifier.isStatic(modifiers)){
                out.append("static ");
            }
            Class<?> returnType = method.getReturnType();
            String returnClassName = returnType.getSimpleName();
            out.append(returnClassName).append(" ");
            out.append(returnClassName).append(SPACE);
            String methodName = method.getName();
            out.append(methodName).append(LEFT_BREKET);

            Class<?>[] types = method.getParameterTypes();
            String delimiter = EMPTY_STRING;
            System.out.println(method);
        }
    }
}
