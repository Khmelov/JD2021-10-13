package by.it.karmyzov.jd01_07;

public class Matrix extends Var {
   private double[][] values;
    public Matrix(double[][] values) {
        this.values = values;
    }
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("{{");
        String delimiter = "";
        for (double[] value : values) {
            out.append(delimiter);
            out.append(value);
            delimiter = ", ";
        }
        out.append("}}");
        return out.toString();
    }


    }
