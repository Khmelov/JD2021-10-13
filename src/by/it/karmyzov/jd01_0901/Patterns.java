package by.it.karmyzov.jd01_0901;

public class Patterns {
       public static final String OPERATION = "[-+/*]";
      static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
     static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR +")*}";
}