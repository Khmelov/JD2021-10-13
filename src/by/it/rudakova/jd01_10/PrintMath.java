package by.it.rudakova.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) throws ClassNotFoundException{
        Class<?> mathClass=Class.forName("java.lang.Math");;
        Method [] methods=mathClass.getDeclaredMethods();
        for(Method method:methods){
            StringBuilder out=new StringBuilder();
            int modifiers=method.getModifiers();
            if(Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)){
                out.append("public static ");
            }

            Class<?> returnType=method.getReturnType();
            String returnClassName=returnType.getSimpleName();
            out.append(returnClassName).append(" ");
            String methodName=method.getName();
            out.append(methodName).append("(");
            Class<?>[]types=method.getParameterTypes();
            String delimiter="";
            for(Class<?> type:types){
                out.append(delimiter).append(type.getSimpleName());
                delimiter=",";
            }
            out.append(")");

            System.out.println(out);
        }
        Field [] fields=mathClass.getDeclaredFields();
        for(Field field:fields){
            StringBuilder out=new StringBuilder();
            int modifiers=field.getModifiers();
            if(Modifier.isPublic(modifiers)) {
                out.append("public ");
            }
            else{
                continue;
            }
            Class<?> returnType=field.getType();
            String returnTypeName=returnType.getSimpleName();
            out.append(returnTypeName).append(" ");
            String fieldName=field.getName();
            out.append(fieldName);
            System.out.println(out);
        }
    }
}
