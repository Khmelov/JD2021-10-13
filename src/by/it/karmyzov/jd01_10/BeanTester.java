package by.it.karmyzov.jd01_10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class BeanTester { // разобраться

    public static void main(String[] args) throws Exception {

        Class<Bean> c = Bean.class;
        Constructor<?> constructor=c.getConstructor();
        Object finder=constructor.newInstance();
        Method[] methods=c.getDeclaredMethods();
        for(Method method:methods){
            if(method.isAnnotationPresent(Param.class)){
                Param foundAnnotation=method.getAnnotation(Param.class);
                Object result= method.invoke(finder, foundAnnotation.a(),foundAnnotation.b());
                System.out.println(method.getName()+" "+result);
            }
        }
    }

}
