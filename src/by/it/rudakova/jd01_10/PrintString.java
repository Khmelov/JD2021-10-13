package by.it.rudakova.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> stringClass= Class.forName("java.lang.String");
        Method[] methods=stringClass.getDeclaredMethods();
        for(Method method:methods){
            int modifiers=method.getModifiers();
            if(Modifier.isStatic(modifiers)){
                continue;
            }
            else{
                System.out.println(method.getName());
            }
        }
    }
}
