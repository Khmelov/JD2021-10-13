package by.it.karmyzov.jd01_08;

public class Vector extends Var {

    private double[] values;

    public Vector(double[] values) {
        this.values = values;
    }

    public Vector(Vector tovector) {
        this.values = tovector.values;
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
