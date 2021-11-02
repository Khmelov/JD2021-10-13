package by.it.shcharbunou.jd01_07;

public class Vector extends Var {
    private final double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        String regex = "[^0-9.+-]";
        String noSpacesStrVector = strVector.replaceAll(" ", "");
        noSpacesStrVector = noSpacesStrVector.substring(1, noSpacesStrVector.length() - 1);
        String[] stringValues = noSpacesStrVector.split(regex);
        double[] doublesArray = new double[stringValues.length];
        for (int i = 0; i < doublesArray.length; i++) {
            doublesArray[i] = Double.parseDouble(stringValues[i]);
        }
        this.value = doublesArray;
    }

    @Override
    public String toString() {
        StringBuilder stringArrayPerformance = new StringBuilder();
        stringArrayPerformance.append('{');
        for (int i = 0; i < value.length; i++) {
            stringArrayPerformance.append(value[i]);
            if (i != value.length - 1) {
                stringArrayPerformance.append(", ");
            }
        }
        stringArrayPerformance.append('}');
        return stringArrayPerformance.toString();
    }
}
