package by.it.karmyzov.calc;

public class Scalar extends Var {
    private final double value;

    public double getValue() {
        return value;
    }

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String str) {
        this.value = Double.parseDouble(str);
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        if (other instanceof Scalar scalar) {
            double result = this.value + scalar.value;
            return new Scalar(result);
        } else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        if (other instanceof Scalar scalar) {
            double result = this.value - scalar.value;
            return new Scalar(result);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        if (other instanceof Scalar scalar) {
            double result = this.value * scalar.value;
            return new Scalar(result);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        if (other instanceof Scalar scalar) {
            if (scalar.value == 0) {
                String message = String.format("Division by zero %s / %s%n", this, other);
                throw new CalcExeption(message);
            }
            double result = this.value / scalar.value;
            return new Scalar(result);
        }
        return super.div(other);
    }

}




