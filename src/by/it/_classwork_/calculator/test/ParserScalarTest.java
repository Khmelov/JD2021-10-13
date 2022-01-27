package by.it._classwork_.calculator.test;

import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.services.Parser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParserScalarTest {
    @Parameterized.Parameter(0)
    public String expression;
    @Parameterized.Parameter(1)
    public int expected;

    @Parameterized.Parameters(name = "{index}: {0}={1}")
    public static Object[][] parameters() {
        return new Object[][]{
                {"1+2+3", 6},
                {"4*3/2+1", 7},
                {"A=2", 2},
                {"A=1+2+3", 6},
        };
    }

    @Test
    public void scalarExpression() {
        Parser parser = new Parser(null);
        Var result = parser.calc(expression);
        double actual = Double.parseDouble(result.toString());
        assertEquals(expression, expected, actual, 1e-10);
    }
}