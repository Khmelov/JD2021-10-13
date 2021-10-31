package by.it.rudakova.jd01_07;

public class Scalar extends Var {
    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    public Scalar(String stringValue) {
        this.value = Double.parseDouble(stringValue);
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}
