package by.it.rudakova.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    double value[][];

    public Matrix(double[][] otherValue) {
        this.value = otherValue;
    }

    public Matrix(Matrix otherMatrix) {
        this.value = otherMatrix.value;
    }

    public Matrix(String strMatrix) {
        StringBuilder line = new StringBuilder(strMatrix);
        Pattern pattern = Pattern.compile("[\\d]+[.]*[\\d]*");
        Matcher matcher = pattern.matcher(line);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        String[] arrayGroups = new String[counter];
        matcher.reset();
        int i = 0;
        while (matcher.find()) {
            arrayGroups[i] = strMatrix.substring(matcher.start(), matcher.end());
            i++;
        }
        int lengthArray = (int) Math.sqrt(arrayGroups.length);
        double[][] newArray = new double[lengthArray][lengthArray];
        i = 0;
        for (int j = 0; j < newArray.length; j++) {
            for (int k = 0; k < newArray.length; k++) {
                newArray[j][k] = Double.parseDouble(arrayGroups[i]);
                i++;
            }
        }
        value = newArray;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{{");
        for (int k = 0; k < value[0].length; k++) {
            stringBuilder.append(value[0][k]);
            if (k != value[0].length-1) {
                stringBuilder.append(',');
            }
        }
        stringBuilder.append("}, {");
        for (int k = 0; k < value[1].length; k++) {
            stringBuilder.append(value[1][k]);
            if (k != value[1].length-1) {
                stringBuilder.append(',');
            }
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
