package by.it.malyshchik.jd01_07;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        String string = strVector;
        string=string.replace("{", "");
        string=string.replace("}", "");
        string=string.replace(" ", "");
        String[] strArray = string.split("[,]");
        double[] numberArray = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            numberArray[i] = Double.parseDouble(strArray[i]);
        }
        this.value = numberArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            sb.append(delimiter).append(value[i]);
            delimiter = ", ";

        }
        sb.append("}");
        return sb.toString();

    }
}
