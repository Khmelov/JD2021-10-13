package by.it.rudakova.jd01_07;

public class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector otherVector) {
        this.value = otherVector.value;
    }

    public Vector(String strVector) {
        strVector = strVector.replace(strVector.charAt(0), ' ');
        strVector = strVector.replace(strVector.charAt(strVector.length() - 1), ' ');
        String trimedString = strVector.trim();
        String[] strArray = trimedString.split(",");
        double[] newArray = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            newArray[i] = Double.parseDouble(strArray[i]);
        }
        this.value = newArray;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        for (int i = 0; i < value.length; i++) {
            stringBuilder.append(value[i]);
            if (i != value.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append('}');

        return stringBuilder.toString();
    }
}
