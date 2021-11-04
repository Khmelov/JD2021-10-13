package by.it.oliakhevich.jd01_10;


import java.lang.reflect.Method;

public class BeanTester {
     public static void main(String[] args) throws Exception {
          Class<String> stringClass = String.class;
          Method[] Methods = stringClass.getDeclaredMethods();
          for (Method Method : Methods) {



          }



     }




}
