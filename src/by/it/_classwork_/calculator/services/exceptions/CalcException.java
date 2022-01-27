package by.it._classwork_.calculator.services.exceptions;

public class CalcException extends RuntimeException {

    public CalcException(String message) {
        super("ERROR: " + message);
    }

    public CalcException(String format, Object... args) {
        super(String.format(format, args));
    }

}
