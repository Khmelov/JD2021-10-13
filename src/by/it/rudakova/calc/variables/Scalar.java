package by.it.rudakova.calc.variables;


import by.it.rudakova.calc.exceptions.CalcException;

public class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    public Scalar(double value) {

        this.value = value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else {
            return new Scalar(-1).mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        } else {
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if(((Scalar)other).value==0)
                throw new CalcException("Деление на ноль");
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        } else {
            return super.div(this);
        }
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
