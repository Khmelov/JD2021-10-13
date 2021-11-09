package by.it.ena.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static final String LEFT_BRACKET = "(";
    public static final String SPACE = " ";
    public static final String EMPTY_STRING = "";
    public static final String COMMA = ",";
    public static final String RIGHT_BRACKET = ")";

    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder out=new StringBuilder();
            int modifiers=method.getModifiers();

            if(Modifier.isPublic(modifiers)){
                out.append("public ");
            }
            else {
                continue;
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

            Class<?> returnType=method.getReturnType();
            String returnClassName= returnType.getSimpleName();
            out.append(returnClassName).append(SPACE);
            String methodName=method.getName();
            out.append(methodName).append(LEFT_BRACKET);

            Class<?>[] types=method.getParameterTypes();
            String delimeter=EMPTY_STRING;
            for (Class<?> type:types) {
                out.append(delimeter).append(type.getSimpleName());
                delimeter=COMMA;
            }
            out.append(RIGHT_BRACKET);
            System.out.println(out);

        }

        Field[] fields=structMath.getDeclaredFields();
        for(Field field: fields){
            StringBuilder outTwo=new StringBuilder();
            int modifiers=field.getModifiers();

            if(Modifier.isPublic(modifiers)){
                outTwo.append("public ");
            }
            else {
                continue;
            }
            Class<?> returnTypeTwo=field.getType();
            String returnClassName= returnTypeTwo.getSimpleName();
            outTwo.append(returnClassName).append(SPACE);
            String methodName=field.getName();
            outTwo.append(methodName);


            System.out.println(outTwo);
        }

    }
}
