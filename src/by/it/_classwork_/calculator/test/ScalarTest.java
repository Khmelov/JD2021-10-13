package by.it._classwork_.calculator.test;

import by.it._classwork_.calculator.model.Scalar;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScalarTest  {

    private static final double DELTA = 1e-10;

    @Test
    public void doubleConstructor() {
        double expected = 1.2345;
        Scalar scalar = new Scalar(expected);
        assertEquals(expected, scalar.getValue(), DELTA);
    }

    @Test
    public void stringConstructor() {
        double expected = 1.2345;
        Scalar scalar = new Scalar("1.2345");
        assertEquals(expected, scalar.getValue(), DELTA);
    }

}