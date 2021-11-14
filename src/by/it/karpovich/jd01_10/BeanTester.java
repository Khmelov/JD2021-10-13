package by.it.karpovich.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) throws Exception {
        Class<?> beanClass = Class.forName("by.it.karpovich.jd01_10.Bean");
        Constructor<?> constructor = beanClass.getConstructor();
        Object finder = constructor.newInstance();
        Method[] beanMethods = beanClass.getDeclaredMethods();

        for (Method method : beanMethods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param foundAnnotation = method.getAnnotation(Param.class);
                Object methodResult = method.invoke(finder, foundAnnotation.a(), foundAnnotation.b());
                System.out.println(method.getName() + " " + methodResult);
            }
        }
    }
}