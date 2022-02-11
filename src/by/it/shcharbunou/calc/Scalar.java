package by.it.shcharbunou.calc;

import java.util.Locale;

public class Scalar extends Var {
    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other, Locale locale) {
        if (other instanceof Scalar) {
            double amount = this.value + ((Scalar) other).value;
            return new Scalar(amount);
        } else {
            return other.add(this, locale);
        }
    }

    @Override
    public Var sub(Var other, Locale locale) {
        if (other instanceof Scalar) {
            double difference = this.value - ((Scalar) other).value;
            return new Scalar(difference);
        } else {
            return new Scalar(-1).mul(other, locale).add(this, locale);
        }
    }

    @Override
    public Var mul(Var other, Locale locale) {
        if (other instanceof Scalar) {
            double multiplied = this.value * ((Scalar) other).value;
            return new Scalar(multiplied);
        } else {
            return other.mul(this, locale);
        }
    }

    @Override
    public Var div(Var other, Locale locale) {
        if (other instanceof Scalar) {
            double quotient = this.value / ((Scalar) other).value;
            return new Scalar(quotient);
        } else {
            return super.div(other, locale);
        }
    }

    public double getValue() {
        return value;
    }
}
