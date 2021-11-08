package by.it.karmyzov.calc;

public class Patterns {
       static final String OPERATION = "[-=+/*]";
      static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
     static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR +")*}";
}