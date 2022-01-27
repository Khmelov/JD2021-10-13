package by.it._classwork_.calculator.model;

import java.util.Arrays;
import java.util.StringJoiner;

import static by.it._classwork_.calculator.constants.SubStrings.*;

public class Vector extends Var {

    private final double[] values;

    public Vector(double[] values) {
        this.values = values.clone();
    }

    public Vector(String string) {
        values = Arrays.stream(string
                        .replace(SPACES, EMPTY_STRING)
                        .replace(LEFT_BRACKET, EMPTY_STRING)
                        .replace(RIGHT_BRACKET, EMPTY_STRING)
                        .split(COMMA))
                .mapToDouble(Double::parseDouble)
                .toArray();
    }

    public Vector(Vector vector) {
        this(vector.values);
    }

    public double[] getValues() {
        return values.clone();
    }

    @Override
    public String toString() {
        StringJoiner vector = joiner();
        for (double value : values) {
            vector.add(Double.toString(value));
        }
        return vector.toString();
    }
}
