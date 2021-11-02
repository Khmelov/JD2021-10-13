package by.it.shcharbunou.jd01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll(" ", "");
        strMatrix = strMatrix.substring(1, strMatrix.length() - 1);
        strMatrix = strMatrix.replaceAll("},", "} ");
        String rowsRegex = "[{][0-9.,+-]+[}]";
        Pattern pattern = Pattern.compile(rowsRegex);
        Matcher matcher = pattern.matcher(strMatrix);
        int rowsCount = findRowsCount(matcher);
        int columnsCount = findColumnsCount(strMatrix);
        double[][] matrix = new double[rowsCount][columnsCount];
        String[] rowsString = strMatrix.split(" ");
        fillMatrix(rowsString, matrix);
        this.value = matrix;
    }

    private void fillMatrix(String[] rowsString, double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = getRow(rowsString, i);
        }
    }

    private double[] getRow(String[] rowsString, int rowIndex) {
        rowsString[rowIndex] = rowsString[rowIndex].substring(1, rowsString[rowIndex].length() - 1);
        String[] temporaryRowStringArray = rowsString[rowIndex].split("[^0-9.+-]");
        double[] temporaryRowArray = new double[temporaryRowStringArray.length];
        for (int i = 0; i < temporaryRowArray.length; i++) {
            temporaryRowArray[i] = Double.parseDouble(temporaryRowStringArray[i]);
        }
        return temporaryRowArray;
    }

    private int findColumnsCount(String strMatrix) {
        int counter = 0;
        int i = 1;
        while (strMatrix.charAt(i) != '}') {
            if (strMatrix.charAt(i) == ',') {
                counter++;
            }
            i++;
        }
        counter++;
        return counter;
    }

    private int findRowsCount(Matcher matcher) {
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    @Override
    public String toString() {
        StringBuilder stringMatrixPerformance = new StringBuilder();
        stringMatrixPerformance.append('{');
        for (int i = 0; i < value.length; i++) {
            stringMatrixPerformance.append('{');
            for (int j = 0; j < value[i].length; j++) {
                stringMatrixPerformance.append(value[i][j]);
                if (j != value[i].length - 1) {
                    stringMatrixPerformance.append(", ");
                }
            }
            stringMatrixPerformance.append('}');
            if (i != value.length - 1) {
                stringMatrixPerformance.append(", ");
            }
        }
        stringMatrixPerformance.append('}');
        return stringMatrixPerformance.toString();
    }
}
