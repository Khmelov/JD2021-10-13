package by.it.rudakova.calc.tests;

import by.it.rudakova.calc.variables.Parser;
import by.it.rudakova.calc.variables.Var;
import by.it.rudakova.calc.repository.VarRepository;
import by.it.rudakova.calc.variables.Vector;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test_jd02_04 {

    private static final double DELTA =1e-10;
    private Parser parser;
    @Before
    public void init(){
        VarRepository varRepository=new VarRepository();
        parser=new Parser(varRepository);
    }
    @Test(timeout = 5000)
    public void  scalarAddition() throws Exception{
        String expression="-2+-2*2-4+12";
        Var actualVar=parser.calc(expression);
        double actual=Double.parseDouble(actualVar.toString());
        double expected=2;
        assertEquals(expected,actual,DELTA);
    }

    @Test(timeout = 5000)
    public void  scalarAdditionWithOneVar() throws Exception{
        String expression="A=2+5.3";
        Var actualVar=parser.calc(expression);
        double actual=Double.parseDouble(actualVar.toString());
        double expected=7.3;
        assertEquals(expected,actual,DELTA);
    }
    @Test(timeout = 5000)
    public void  vectorMultScalar() throws Exception{
        String expression="{1,2,3}*3";
        Var actualVar=parser.calc(expression);
        Vector expected=new Vector("{3.0,6.0,9.0}");
        assertEquals(expected.toString(),actualVar.toString());
    }

    @Test(timeout = 5000)
    public void  vectorDivScalar() throws Exception{
        String expression="{3,6,9}/3";
        Var actualVar=parser.calc(expression);
        Vector expected=new Vector("{1,2,3}");
        assertEquals(expected.toString(),actualVar.toString());
    }
    @Test(timeout = 5000)
    public void  vectorAddVector() throws Exception{
        String expression="{3,6,9}+{1,2,3}";
        Var actualVar=parser.calc(expression);
        Vector expected=new Vector("{4,8,12}");
        assertEquals(expected.toString(),actualVar.toString());
    }
    @Test(timeout = 5000)
    public void  vectorSubVector() throws Exception{
        String expression="{3,6,9}-{1,2,3}";
        Var actualVar=parser.calc(expression);
        Vector expected=new Vector("{2,4,6}");
        assertEquals(expected.toString(),actualVar.toString());
    }
    @Test(timeout = 5000)
    public void  vectorSubScalar() throws Exception{
        String expression="{3,6,9}-4";
        Var actualVar=parser.calc(expression);
        Vector expected=new Vector("{-1,2,5}");
        assertEquals(expected.toString(),actualVar.toString());
    }
    @Test(timeout = 5000)
    public void  orderOne() throws Exception{
        String expression="{3,6,9}-(6/2)";
        Var actualVar=parser.calc(expression);
        Vector expected=new Vector("{0,3,6}");
        assertEquals(expected.toString(),actualVar.toString());
    }
    @Test(timeout = 5000)
    public void  orderTwo() throws Exception{
        String expression="({3,6,9}-(6/2))*3";
        Var actualVar=parser.calc(expression);
        Vector expected=new Vector("{0,9,18}");
        assertEquals(expected.toString(),actualVar.toString());
    }
}
