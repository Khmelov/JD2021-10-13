package by.it.shcharbunou.calc;

public final class Samples {
    public static final String OPERATION = "[-+*/]";
    public static final String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    public static final String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    public static final String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
    public static final String VARIABLE = "[a-zA-Z]";

    private Samples() {}
}
