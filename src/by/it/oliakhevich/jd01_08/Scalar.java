package by.it.oliakhevich.jd01_08;

class Scalar extends Var { //Наследуется от класса Var
    private final double value;


    Scalar(double value) {
        this.value = value;

    }


    Scalar(String str) {
        this.value = Double.parseDouble(str);
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);

        } else
            return other.add(this);

    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);

        } else
            return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);

        } else
            return other.add(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);

        }
        return super.div(other);
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}


