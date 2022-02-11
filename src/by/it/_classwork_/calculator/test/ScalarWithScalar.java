package by.it._classwork_.calculator.test;

import by.it._classwork_.calculator.model.Scalar;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.services.creators.Operation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ScalarWithScalar {
    @Parameterized.Parameters(name = "{index}: {0}{1}{2}={3}")
    public static Object[][] parameters() {
        return new Object[][]{
                {"1", "+", "2", 3},
                {"9", "-", "2", 7},
                {"2", "*", "2", 4},
                {"6", "/", "2", 3},
        };
    }

    @Parameterized.Parameter(0)
    public String left;
    @Parameterized.Parameter(1)
    public String operation;
    @Parameterized.Parameter(2)
    public String right;
    @Parameterized.Parameter(3)
    public int expected;

    @Test
    public void scalarWithScalar() {
        Var p = new Scalar(left);
        Var q = new Scalar(right);
        Operation plus = new Operation(p, operation, q);
        double actual = Double.parseDouble(plus.getResult().toString());
        assertEquals(left+operation+right, expected, actual, 1e-10);
    }
}