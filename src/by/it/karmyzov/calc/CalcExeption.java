package by.it.karmyzov.calc;

public class CalcExeption extends Exception {

    public CalcExeption(String message) {
        super("ERROR:" + message);
    }

    public CalcExeption(String message, Throwable cause) {
        super("ERROR:" + message, cause);
    }

    public CalcExeption(Throwable cause) {
        super(cause);
    }

    public CalcExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR:" + message, cause, enableSuppression, writableStackTrace);
    }
}
