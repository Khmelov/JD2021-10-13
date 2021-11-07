package by.it.shcharbunou.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws Exception {
        Class<?> beanClass = Class.forName("by.it.shcharbunou.jd01_10.Bean");
        Constructor<?> beanConstructor = beanClass.getConstructor();
        Bean beanObject = (Bean) beanConstructor.newInstance();
        Method[] beanMethods = beanClass.getDeclaredMethods();
        printAnswer(beanObject, beanMethods);
    }

    private static void printAnswer(Bean beanObject, Method[] beanMethods) throws IllegalAccessException, InvocationTargetException {
        for (Method beanMethod : beanMethods) {
            if (beanMethod.isAnnotationPresent(Param.class)) {
                Param paramAnnotation = beanMethod.getAnnotation(Param.class);
                Object methodResult = beanMethod.invoke(beanObject, paramAnnotation.a(), paramAnnotation.b());
                System.out.println(beanMethod.getName() + " " + methodResult);
            }
        }
    }
}
