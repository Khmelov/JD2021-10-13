
package by.it.malyshchik.calc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Test_jd02_04 {

    public static final double DELTA = 1e-10;
    private Parser parser;

    @Before
    public void init() {
        VarRepository varRepository = new VarRepository();
        parser = new Parser(varRepository);
    }

    @Test(timeout = 5000)
    public void scalarAddition() throws Exception {
        String expression = "-2+-2*2-4+12";
        Var actualVar = parser.calc(expression);
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 2;
        assertEquals(expected, actual, DELTA);
    }

    @Test(timeout = 5000)
    public void scalarAdditionWithOneVarA() throws Exception {
        Var actualVar = parser.calc("A=2+5.3");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 7.3;
        assertEquals(expected, actual, DELTA);

        actualVar = parser.calc("B=A*3.5");
        actual = Double.parseDouble(actualVar.toString());
        expected = 25.55;
        assertEquals(expected, actual, DELTA);

        actualVar = parser.calc("B1=B+0.11*-5");
        actual = Double.parseDouble(actualVar.toString());
        expected = 25;
        assertEquals(expected, actual, DELTA);

        actualVar = parser.calc("B2=A/2-1");
        actual = Double.parseDouble(actualVar.toString());
        expected = 2.65;
        assertEquals(expected, actual, DELTA);
    }

    @Test(timeout = 5000)
    public void vectorTestB() throws Exception {
        Var actualVar;
        actualVar = parser.calc("C=25.55+(7.3*2)");
        double actual = Double.parseDouble(actualVar.toString());
        double expected = 40.15;
        assertEquals(expected, actual, DELTA);

        actualVar = parser.calc("D=((40.15-0.15)-20)/(7-5)");
        actual = Double.parseDouble(actualVar.toString());
        expected = 10;
        assertEquals(expected, actual, DELTA);


        Vector vector;
        vector = (Vector) parser.calc("E={2,3}*(10/2)");
        double[] actualV = vector.getValues();
        double[] excpectedV = {10,15};
        assertArrayEquals(excpectedV, actualV, DELTA);

    }


}

