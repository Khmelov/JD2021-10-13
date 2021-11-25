package by.it.rudakova.calc;

public class CalcException extends Exception {
    public CalcException() {
        this("no message");
    }

    public CalcException(String message) {
        super("ERROR:"+message);
    }

    public CalcException(String message, Throwable cause) {
        super("ERROR:"+message, cause);
    }

    public CalcException(Throwable cause) {
        this("no message",cause);
    }

}
