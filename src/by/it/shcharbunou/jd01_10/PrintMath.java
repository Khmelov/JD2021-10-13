package by.it.shcharbunou.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] mathMethods = mathClass.getDeclaredMethods();
        printMathMethods(mathMethods);
        Field[] mathFields = mathClass.getDeclaredFields();
        printMathField(mathFields);
    }

    private static void printMathField(Field[] mathFields) {
        for (Field mathField : mathFields) {
            StringBuilder fieldSimpleName = new StringBuilder();
            if ((mathField.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                fieldSimpleName.append("public ");
                if ((mathField.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                    fieldSimpleName.append("static ");
                }
                fieldSimpleName.append(mathField.getType().getSimpleName());
                fieldSimpleName.append(" ");
                fieldSimpleName.append(mathField.getName());
                System.out.println(fieldSimpleName);
            }
        }
    }

    private static void printMathMethods(Method[] mathMethods) {
        for (Method mathMethod : mathMethods) {
            StringBuilder methodSimpleName = new StringBuilder();
            if ((mathMethod.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                methodSimpleName.append("public ");
                if ((mathMethod.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
                    methodSimpleName.append("static ");
                }
                methodSimpleName.append(mathMethod.getReturnType().getSimpleName());
                methodSimpleName.append(" ");
                methodSimpleName.append(mathMethod.getName()).append("(");
                Class<?>[] parameterTypes = mathMethod.getParameterTypes();
                if (parameterTypes.length != 0) {
                    for (Class<?> parameterType : parameterTypes) {
                        methodSimpleName.append(parameterType.getName()).append(",");
                    }
                    methodSimpleName.deleteCharAt(methodSimpleName.length() - 1);
                }
                methodSimpleName.append(")");
                System.out.println(methodSimpleName);
            }
        }
    }
}
