package by.it.karpovich.jd01_08;

import static by.it.karpovich.jd01_08.Patterns.*;


public class Matrix extends Var {
    private final double[][] value; // Создаем защиту от вмешательства

    // Начало первого конструктора:
    public Matrix(double[][] value) {
        this.value = value;
    }

    // Начало второго конструктора:
    public Matrix(Matrix value) {
        this.value = value.value;
    }

    // Начало третьего конструктора:
    public Matrix(String strMatrix) {
        String line = strMatrix.substring(2, strMatrix.length() - 2);
        String[] strArrI = line.split(SPLIT_MATRIX);
        double[][] outputArray = new double[strArrI.length][strArrI[0].split(COMMA).length];
        for (int i = 0; i < strArrI.length; i++) {
            String[] strArrJ = strArrI[i].split(COMMA);
            int k = 0;
            for (int j = 0; j < strArrJ.length; j++) {
                outputArray[i][j] = Double.parseDouble(strArrJ[k]);
                k++;
            }
        }
        this.value = outputArray;
    }


    public String toString() {
        StringBuilder output = new StringBuilder(LEFT_BRACKET);
        for (double[] doubles : value) {
            String limiter = EMPTY_STRING;
            output.append(LEFT_BRACKET);
            for (double aDouble : doubles) {
                output.append(limiter);
                output.append(aDouble);
                limiter = INDENTED_COMMA;
            }
            limiter = INDENTED_RIGHT_BRACKET_COMMA;
            output.append(limiter);
        }
        output.delete(output.length() - 2, output.length());
        output.append(RIGHT_BRACKET);
        return output.toString();
    }

    public double[][] getValue() {
        return value;
    }
}