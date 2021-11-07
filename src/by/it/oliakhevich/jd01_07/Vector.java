package by.it.oliakhevich.jd01_07;

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
}


