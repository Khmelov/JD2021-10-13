package by.it.marukovich.calc;

import java.util.Arrays;

public class Vector extends Var {


    public static final String SPACES = ",\\s*";
    private final double[] values;

    public Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public Vector(Vector vector) {
        this(vector.values);
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
    }

    public double[] getValues() {
        return Arrays.copyOf(values, values.length);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            double[] result = Arrays.copyOf(values, values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + scalar.getValue();
            }
            return new Vector(result);
        }
        if (other instanceof Vector vector) {
            if (this.values.length != vector.values.length) {
                throw new CalcException(String.format("Incorrect vectors size: %s + %s", this, vector));
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
    public Var sub(Var other) throws CalcException {
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
    public Var mul(Var other) throws CalcException {
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
                sum += result[i];
            }
            return new Scalar(sum);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            double[] result = Arrays.copyOf(values, values.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / scalar.getValue();

            }
            return new Vector(result);

        } else return super.div(other);
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
