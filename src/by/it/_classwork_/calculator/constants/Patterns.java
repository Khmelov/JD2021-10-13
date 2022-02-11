package by.it._classwork_.calculator.constants;

public interface Patterns {

    String OPERATION = "[-+*/=]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";
    String VARNAME = "[a-zA-Z][a-zA-Z0-9]*";

}
