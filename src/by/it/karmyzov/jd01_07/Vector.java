package by.it.karmyzov.jd01_07;

import java.util.Arrays;



public class Vector extends Var {

    public static final String DELIMITER = ",\\s*";
    public static final String LEFT_BRACKET = "{";
    public static final String RIGHT_BRACKET = "}";

    private double[] values;

    public Vector(double[] values) {
        this.values = values;
    }

    public Vector(Vector tovector) {
        this.values = tovector.values;
    }

    public Vector(String strVector) {

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

