package by.it.antipov.calc.jd01_09;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCalc {
    Parser calculation = new Parser();

    @Test//(timeout = 5000)
    public void TaskA() throws CalcException {

        Scalar scalar = new Scalar((Scalar) calculation.calcAll("A=2+5.3"));
        Scalar scalar1 = new Scalar((Scalar) calculation.calcAll("B=A*3.5"));
        Scalar scalar2 = new Scalar((Scalar) calculation.calcAll("B1=B+0.11*-5"));
        Scalar scalar3 = new Scalar((Scalar) calculation.calcAll("B2=A/2-1"));
        Assert.assertEquals("7.3",scalar.toString());
        Assert.assertEquals("25.55",scalar1.toString());
        Assert.assertEquals("25.0",scalar2.toString());
        Assert.assertEquals("2.65",scalar3.toString());
    }
    @Test//(timeout = 5000)
public void TaskB() throws CalcException{
    Scalar scalar = new Scalar((Scalar) calculation.calcAll("C=B+(A*2)"));
    Scalar scalar1 = new Scalar((Scalar) calculation.calcAll("D=((C-0.15)-20)/(7-5)"));
    Vector vector= new Vector((Vector) calculation.calcAll("E={2,3}*(D/2)"));
    Assert.assertEquals("40.15",scalar.toString());
    Assert.assertEquals("10",scalar1.toString());
    Assert.assertEquals("{10,15}",vector.toString());
}



}

