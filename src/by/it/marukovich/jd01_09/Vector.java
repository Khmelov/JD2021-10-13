package by.it.marukovich.jd01_09;

import java.util.Arrays;

public class Vector extends Var {
    private final double[] values;

    public Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public double[] getValues() {
        return Arrays.copyOf(values, values.length);
    }

    public Vector(Vector vector) {
        this(vector.values);
    }

    public Vector(String strVector) {
        strVector = strVector
                .replace("{", "")
                .replace("}", "")
                .trim();
        String[] strings = strVector.split(",\\s*");
        values = new double[strings.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(strings[i]);
        }
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
        if (other instanceof Scalar scalar) {
            double[] result = Arrays.copyOf(values, values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - scalar.getValue();
            }
            return new Vector(result);
        }
        if (other instanceof Vector vector) {
            if (this.values.length != vector.values.length) {
                return super.add(vector);
            }
            double[] result = Arrays.copyOf(values, values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - vector.values[i];
            }
            return new Vector(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        double sum = 0;
        if (other instanceof Scalar scalar) {
            double[] result = Arrays.copyOf(values, values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * scalar.getValue();
                sum += result[i];
            }
            return new Vector(result);
        }
        if (other instanceof Vector vector) {
            double[] result = Arrays.copyOf(values, values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * vector.values[i];
                sum+=result[i];
            }
            return new Scalar(sum);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar) {
            double[] result = Arrays.copyOf(values, values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / scalar.getValue();

            }
            return new Vector(result);

        }
        else return super.div(other);
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
