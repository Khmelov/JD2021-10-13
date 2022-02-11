package by.it.karpovich.jd01_09;

import java.util.Arrays;

import static by.it.karpovich.jd01_09.Patterns.LEFT_BRACKET;
import static by.it.karpovich.jd01_09.Patterns.RIGHT_BRACKET;

public class Vector extends Var {


    private final double[] values; // Создаем защиту от вмешательства

    // Начало первого конструктора:
    public Vector(double[] value) {
        this.values = Arrays.copyOf(value, value.length);
    }

    // Начало второго конструктора:
    public Vector(Vector vector) {
        this.values = vector.values;
    }

    // Начало третьего конструктора:
    public Vector(String strVector) {
        String[] strArr = strVector.split("[/{, }]+");
        strArr = Arrays.copyOfRange(strArr, 1, strArr.length);
        double[] array = new double[strArr.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(strArr[i]);
        }
        this.values = array;
    }

    //_________________________________________________________________________________________________________________

    /*  public Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public Vector(String stringVar) {
        String[] strValues = stringVar
                .replace(Patterns.LEFT_BRACKET, "")
                .replace(Patterns.RIGHT_BRACKET, "")
                .split(SPACES);
        values = new double[strValues.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(strValues[i]);
        }

    } */

    public double[] getValues() {
        return Arrays.copyOf(values, values.length);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = Arrays.copyOf(values, values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + scalar.getValue();
            }
            return new Vector(result);
        }
        if (other instanceof Vector vector) {
            if (this.values.length != vector.values.length) {
                return super.add(vector);
            }
            double[] result = Arrays.copyOf(values, values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + vector.values[i];
            }
            return new Vector(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] firstOperand = Arrays.copyOf(this.values, this.values.length);
            double secondOperand = ((Scalar) other).getValue();
            for (int i = 0; i < firstOperand.length; i++) {
                firstOperand[i] -= secondOperand;
            }
            return new Vector(firstOperand);
        } else if (other instanceof Vector && this.values.length == ((Vector) other).values.length) {
            double[] firstOperand = Arrays.copyOf(this.values, this.values.length);
            for (int i = 0; i < firstOperand.length; i++) {
                firstOperand[i] -= ((Vector) other).values[i];
            }
            return new Vector(firstOperand);
        }
        return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] firstOperand = Arrays.copyOf(this.values, this.values.length);
            double secondOperand = ((Scalar) other).getValue();
            for (int i = 0; i < firstOperand.length; i++) {
                firstOperand[i] = firstOperand[i] * secondOperand;
            }
            return new Vector(firstOperand);
        } else if (other instanceof Vector && this.values.length == ((Vector) other).values.length) {
            double result = 0;
            double[] firstOperand = Arrays.copyOf(this.values, this.values.length);
            for (int i = 0; i < firstOperand.length; i++) {
                result += firstOperand[i] * ((Vector) other).values[i];
            }
            return new Scalar(result);
        }
        return super.add(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] firstOperand = Arrays.copyOf(this.values, this.values.length);
            double secondOperand = ((Scalar) other).getValue();
            for (int i = 0; i < firstOperand.length; i++) {
                firstOperand[i] = firstOperand[i] / secondOperand;
            }
            return new Vector(firstOperand);
        }
        return super.div(other);
    }


    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(LEFT_BRACKET);
        String delimiter = "";
        for (double value : values) {
            out.append(delimiter);
            out.append(value);
            delimiter = ", ";
        }
        out.append(RIGHT_BRACKET);
        return out.toString();
    }
}
