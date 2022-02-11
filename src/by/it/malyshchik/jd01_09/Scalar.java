package by.it.malyshchik.jd01_09;

public class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double sum = this.value+((Scalar) other).value;
            return new Scalar(sum);
        }
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double sub = this.value-((Scalar) other).value;
            return new Scalar(sub);
        }
        else
            return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double mul = this.value*((Scalar) other).value;
            return new Scalar(mul);
        }
        else
            return  other.mul(this);
    }

    @Override
    public Var div(Var other) {


        if (other instanceof Scalar){
            double div = this.value/((Scalar) other).value;
            return new Scalar(div);
        }

//        if (other instanceof by.it._classwork_.jd01_08.Scalar scalar) {
//            if (scalar.value == 0) {
//                System.out.printf("Division by zero %s / %s%n", this, other);
//            }
//            double result = this.value / scalar.value;
//            return new by.it._classwork_.jd01_08.Scalar(result);

       else return super.div(other);
}
    Scalar(String str) {
        this.value = Double.parseDouble(str);
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
