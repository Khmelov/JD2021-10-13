package by.it._classwork_.jd01_07;

import java.util.Arrays;

public class Vector extends Var {

    public static final String DELIMITER = ",\\s*";
    public static final String LEFT_BRACKET = "{";
    public static final String RIGHT_BRACKET = "}";
    private final double[] values;

    public Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public Vector(Vector vector) {
        this(vector.values);
    }

    public Vector(String strVector) {
        // { 1,2,   3.0, 4}
        strVector = strVector
                .replace(LEFT_BRACKET, "")
                .replace(RIGHT_BRACKET, "")
                .trim();
        String[] strings = strVector.split(DELIMITER);
        values = new double[strings.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(strings[i]);
        }
    }


    public double[] getValues() {
        return Arrays.copyOf(values, values.length);
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
