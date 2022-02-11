package by.it.karpovich.jd01_08;

public class Scalar extends Var {
    private final double value; // Создаем защиту от вмешательства

    // Начало первого конструктора:
    public Scalar(double value) {
        this.value = value;
    }

    // Начало второго конструктора:
    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    // Начало третьего конструктора:
    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        } else return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double sum = this.value - ((Scalar) other).value;
            return new Scalar(sum);
        } else return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double sum = this.value * ((Scalar) other).value;
            return new Scalar(sum);
        } else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double sum = this.value / ((Scalar) other).value;
            return new Scalar(sum);
        } else return other.div(this);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public double getValue() {
        return value;
    }
}
