package by.it._classwork_.calculator.test;


import by.it._classwork_.calculator.model.Vector;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

public class VectorTest {

    public static final double DELTA = 1e-10;

    @Test
    public void doubleConstructor() {
        double[] expected = {1, 2};
        Vector vector = new Vector(expected);
        assertNotEquals(expected, vector.getValues());
        assertArrayEquals(expected, vector.getValues(), DELTA);
    }

    @Test
    public void stringConstructor() {
        double[] expected = {1, 2};
        Vector vector = new Vector("{1.0, 2.0}");
        assertArrayEquals(expected, vector.getValues(), DELTA);
    }
}