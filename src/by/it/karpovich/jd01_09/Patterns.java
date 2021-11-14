package by.it.karpovich.jd01_09;

public interface Patterns {


    String OPERATION = "[-+*/]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";

    String LEFT_BRACKET = "{";
    String RIGHT_BRACKET = "}";
}
