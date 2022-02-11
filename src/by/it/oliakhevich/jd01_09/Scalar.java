package by.it.oliakhevich.jd01_09;

public class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }
    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) { double result=this.value+ ((Scalar) other).value;
            return new Scalar (result);}
        else  return  other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {double result=this.value- ((Scalar) other).value;
            return new Scalar(result);}
        else return  new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) { double result=this.value*((Scalar) other).value;return new Scalar (result);}
        else  return  other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) { double result=this.value/((Scalar) other).value;return new Scalar (result);}
        else return super.div(this);
    }

    public Scalar(double value) {
        this.value=value;
    }
    public Scalar(Scalar scalar){
        this.value=scalar.value;
    }
    public Scalar(String stringValue) {
        this.value = Double.parseDouble(stringValue);
    }
    @Override
    public String toString() {
        return Double.toString(value);
    }
}
