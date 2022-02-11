package by.it._classwork_.calculator.test;

import by.it._classwork_.calculator.model.Scalar;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.model.Vector;
import by.it._classwork_.calculator.services.creators.Operation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class VectorWithScalar {
    @Parameterized.Parameters(name = "{index}: {0}{1}{2}={3}")
    public static Object[][] parameters() {
        return new Object[][]{
                {"{1,2}", "+", "2", "{3.0, 4.0}"},
                {"{3,2}", "-", "2", "{1.0, 0.0}"},
                {"{1,2}", "*", "2", "{2.0, 4.0}"},
                {"{1,2}", "/", "2", "{0.5, 1.0}"},
        };
    }

    @Parameterized.Parameter(0)
    public String left;
    @Parameterized.Parameter(1)
    public String operation;
    @Parameterized.Parameter(2)
    public String right;
    @Parameterized.Parameter(3)
    public String expected;

    @Test
    public void scalarWithScalar() {
        Var p = new Vector(left);
        Var q = new Scalar(right);
        Operation plus = new Operation(p, operation, q);
        String actual = (plus.getResult().toString());
        assertEquals(left + operation + right, expected, actual);
    }
}