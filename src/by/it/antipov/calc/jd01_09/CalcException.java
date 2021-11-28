package by.it.antipov.calc.jd01_09;

public class CalcException extends Exception{
    public CalcException(String message) {
        super("ERROR: " + message);
    }
}
