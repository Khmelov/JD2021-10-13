package by.it.antipov.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Constructor<Bean> constructor = beanClass.getConstructor();
        Bean beanObject = (Bean) constructor.newInstance();
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                System.out.println(annotation);
                System.out.println(method);
                  System.out.println(method.invoke(beanObject,annotation.a(),annotation.b()));
                }


            }

        }
    }
