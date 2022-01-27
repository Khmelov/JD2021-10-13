package by.it._classwork_.calculator.model;

public class Scalar extends Var {

    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String string) {
        this(Double.parseDouble(string));
    }

    public Scalar(Scalar scalar) {
        this(scalar.value);
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
