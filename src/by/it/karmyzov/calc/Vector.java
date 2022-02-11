package by.it.karmyzov.calc;

import java.util.Arrays;


public class Vector extends Var {

    public static final String DELIMITER = ",\\s*";
    public static final String LEFT_BRACKET = "{";
    public static final String RIGHT_BRACKET = "}";

    private final double[] values;

    public Vector(double[] values) {
        this.values = Arrays.copyOf(values,values.length);
    }

    public Vector(Vector tovector) {
        this.values = tovector.values;
    }

    public Vector(String stringVar) {
       String [] strValues = stringVar
                .replace(LEFT_BRACKET, "")
                .replace(RIGHT_BRACKET, "")
                .split(DELIMITER);
        values = new double[strValues.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(strValues[i]);
        }
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        if (other instanceof Vector vector) {
            if (this.values.length != vector.values.length) {
                return super.add(vector);
            }
                double[] res = Arrays.copyOf(values, values.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] + ((Vector) other).values[i];
                }
                return new Vector(res);
            } else
                return super.add(other);
        }

    @Override
    public Var sub(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        if (other instanceof Vector vector) {
            if (this.values.length != vector.values.length) {
                return super.sub(vector);
            }
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).values[i];
            }
            return new Vector(res);
        }
        else
            return super.sub(other);
    }
    @Override
    public Var mul(Var other) throws CalcExeption {  double sum=0;
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(values, values.length);

            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Vector) other).values[i];
                sum = sum + res[i];
            }

            return new Scalar(sum);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(values, values.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
            } return new Vector(res);
            } else
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("{");
        String delimiter = "";
        for (double value : values) {
            out.append(delimiter);
            out.append(value);
            delimiter = ", ";
        }
        out.append("}");
        return out.toString();
    }
}

