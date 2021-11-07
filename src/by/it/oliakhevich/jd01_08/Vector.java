package by.it.oliakhevich.jd01_08;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }


    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("{");
        String delimiter = "";
        for (double value : value) {
            out.append(delimiter);
            out.append(value);
            delimiter = ", ";
        }
        out.append("}");
        return out.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Scalar) other).getValue();

            }
        }
        return super.add(other);
    }

}

