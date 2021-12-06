package by.it.antipov.calc;

import org.junit.Assert;
import org.junit.Test;

public class TestCalc {
    Parser calculation = new Parser();


    @Test//(timeout = 5000)
    public void TaskA() throws CalcException {

        Scalar scalar = new Scalar((Scalar) calculation.calcAll(calculation.calcInBrackets("A=2+5.3")));
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
    Scalar scalar = new Scalar((Scalar) calculation.calcAll(calculation.calcInBrackets("C=B+(A*2)")));
    Scalar scalar1 = new Scalar((Scalar) calculation.calcAll(calculation.calcInBrackets("D=((C-0.15)-20)/(7-5)")));
    Vector vector= new Vector((Vector) calculation.calcAll(calculation.calcInBrackets("E={2,3}*(D/2)")));
    Assert.assertEquals("40.15",scalar.toString());
    Assert.assertEquals("10.0",scalar1.toString());
    Assert.assertEquals("{10.0,15.0}",vector.toString());
}
@Test
public  void TaskC() throws CalcException{
    Matrix matrix = new Matrix((Matrix) calculation.calcAll(calculation.calcInBrackets("F=B+({{1,2},{3,4}}*2)")));
    Matrix matrix1 = new Matrix((Matrix) calculation.calcAll(calculation.calcInBrackets("Y=((F-0.55)-20)*{{2,2},{2,4}}")));

    Assert.assertEquals("{{27.55,29.55},{31.55,33.55}}",matrix.toString());
    Assert.assertEquals("{{32.0,50.0},{48.0,74.0}}",matrix1.toString());
//
}


}

