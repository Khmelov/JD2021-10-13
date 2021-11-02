package by.it._classwork_.jd01_09;

public interface Patterns {

    String OPERATION = "[-+*/]";

    // 2341  123.0  -145  -17.11
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";

    // {-1.2,4,-99,-0,123}
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";

    String MARTIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";

    public static final String LEFT_BRACKET = "{";
    public static final String RIGHT_BRACKET = "}";
}
