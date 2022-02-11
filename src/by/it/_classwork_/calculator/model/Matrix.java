package by.it._classwork_.calculator.model;

import java.util.StringJoiner;

import static by.it._classwork_.calculator.constants.SubStrings.*;

public class Matrix extends Var {

    private final double[][] values;

    public Matrix(double[][] values) {
        this.values = values.clone();
        for (int i = 0; i < this.values.length; i++) {
            this.values[i] = values[i].clone();
        }
    }

    public Matrix(Matrix matrix) {
        this(matrix.values);
    }

    public Matrix(String string) {
        String[] rows = string
                .replaceAll(SPACES, EMPTY_STRING)
                .split(MATRIX_SPLITTER);
        values = new double[rows.length][];
        for (int i = 0, rowsLength = rows.length; i < rowsLength; i++) {
            String[] elements = rows[i]
                    .replace(LEFT_BRACKET, EMPTY_STRING)
                    .replace(RIGHT_BRACKET, EMPTY_STRING)
                    .split(COMMA);
            values[i] = new double[elements.length];
            for (int j = 0; j < values[i].length; j++) {
                values[i][j] = Double.parseDouble(elements[j]);
            }
        }
    }

    public double[][] getValues() {
        double[][] values = this.values.clone();
        for (int i = 0; i < this.values.length; i++) {
            this.values[i] = values[i].clone();
        }
        return values;
    }

    @Override
    public String toString() {
        StringJoiner matrix = joiner();
        for (double[] row : values) {
            StringJoiner vector = joiner();
            for (double value : row) {
                vector.add(Double.toString(value));
            }
            matrix.add(vector.toString());
        }
        return matrix.toString();
    }

}
