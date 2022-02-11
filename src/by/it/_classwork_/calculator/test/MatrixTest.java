package by.it._classwork_.calculator.test;

import by.it._classwork_.calculator.model.Matrix;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

public class MatrixTest {
    private static final double DELTA = 1e-10;

    @Test
    public void doubleConstructor() {
        double[][] expected = {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix(expected);
        double[][] actual = matrix.getValues();
        for (int i = 0; i < matrix.getValues().length; i++) {
            assertNotEquals(expected[i], actual[i]);
            assertArrayEquals(expected[i], actual[i], DELTA);
        }
    }

    @Test
    public void stringConstructor() {
        double[][] expected = {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix("{{1.0, 2.0}, {3.0, 4.0}}");
        double[][] actual = matrix.getValues();
        for (int i = 0; i < matrix.getValues().length; i++) {
            assertArrayEquals(expected[i], actual[i], DELTA);
        }
    }
}
