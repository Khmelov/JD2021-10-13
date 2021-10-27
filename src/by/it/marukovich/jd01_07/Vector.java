package by.it.marukovich.jd01_07;

import java.util.Arrays;

public class Vector extends Var {
    private final double[] values;

    public Vector(double[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    public double[] getValues() {
        return Arrays.copyOf(values, values.length);
    }

    public Vector(Vector vector){
        this.values = vector.values;
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
