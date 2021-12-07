package by.it.ena.calc;

public interface Patterns {

    String OPERATION = "(?<=[^-+*/={,])[-+*/=]";

    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";

    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";

    String MARTIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";

    String LEFT_BRACKET = "{";

    String RIGHT_BRACKET = "}";
}