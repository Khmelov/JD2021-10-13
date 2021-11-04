package by.it.karmyzov.jd01_10;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            StringBuilder out = new StringBuilder();

            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                out.append("public static ");

                Class<?> returnType = method.getReturnType();
                String returnClassname = returnType.getSimpleName();
                out.append(returnClassname).append(" ");
                String methodName = method.getName();
                out.append(methodName).append("(");
                Class<?>[] types = method.getParameterTypes();
                String delimiter = "";
                for (Class<?> type : types) {
                    out.append(delimiter).append(type.getSimpleName());
                    delimiter = ",";
                }
                out.append(")");
            }
            System.out.println(out);
        }
        Field[] fields = mathClass.getDeclaredFields();
        for (Field field : fields) {
            StringBuilder out = new StringBuilder();
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                out.append("public static" + " ");
                Class<?> returnType = field.getType();
                String returnClassname = returnType.getSimpleName();
                out.append(returnClassname).append(" ");
                String fieldName = field.getName();
                out.append(fieldName);
                System.out.println(out);
            }

        }
    }
}