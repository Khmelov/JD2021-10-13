package by.it.shcharbunou.calc;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class Test_jd02_04 {
    private static final Map<String, Var> variableValues = new HashMap<>();
    private static final Parser parser = new Parser();
    private static final Locale locale = Locale.getDefault();

    @Test
    public void testTaskA() {
        String answer;
        answer = Objects.requireNonNull(VarCreator.createVar("7.3", variableValues)).toString();
        Assert.assertEquals(answer, parser.testCalc("A=2+5.3", variableValues, locale).toString());
        answer = Objects.requireNonNull(VarCreator.createVar("25.55", variableValues)).toString();
        Assert.assertEquals(answer, parser.testCalc("B=A*3.5", variableValues, locale).toString());
        answer = Objects.requireNonNull(VarCreator.createVar("25.0", variableValues)).toString();
        Assert.assertEquals(answer, parser.testCalc("B1=B+0.11*-5", variableValues, locale).toString());
        answer = Objects.requireNonNull(VarCreator.createVar("2.65", variableValues)).toString();
        Assert.assertEquals(answer, parser.testCalc("B2=A/2-1", variableValues, locale).toString());
    }

    @Test
    public void testTaskB() {
        String answer;
        answer = Objects.requireNonNull(VarCreator.createVar("40.15", variableValues)).toString();
        Assert.assertEquals(answer, parser.testCalc("C=B+(A*2)", variableValues, locale).toString());
        answer = Objects.requireNonNull(VarCreator.createVar("10.0", variableValues)).toString();
        Assert.assertEquals(answer, parser.testCalc("D=((C-0.15)-20)/(7-5)", variableValues, locale).toString());
        answer = Objects.requireNonNull(VarCreator.createVar("{10.0,15.0}", variableValues)).toString();
        Assert.assertEquals(answer, parser.testCalc("E={2,3}*(D/2)", variableValues, locale).toString());
    }

    @Test
    public void testTaskC() {
        String answer;
        answer = Objects.requireNonNull(VarCreator.createVar("{{2.0,4.0,6.0},{8.0,10.0,12.0},{14.0,16.0,18.0}}",
                variableValues)).toString();
        Assert.assertEquals(answer, parser.testCalc("{{1,2,3},{4,5,6},{7,8,9}}+{{1,2,3},{4,5,6},{7,8,9}}", variableValues, locale)
                .toString());
        answer = Objects.requireNonNull(VarCreator.createVar("{{0.0,0.0,0.0},{0.0,0.0,0.0},{0.0,0.0,0.0}}",
                variableValues)).toString();
        Assert.assertEquals(answer, parser.testCalc("{{1,2,3},{4,5,6},{7,8,9}}-{{1,2,3},{4,5,6},{7,8,9}}", variableValues, locale)
                .toString());
        answer = Objects.requireNonNull(VarCreator.createVar("{{30.0,36.0,42.0},{66.0,81.0,96.0},{102.0,126.0,150.0}}",
                variableValues)).toString();
        Assert.assertEquals(answer, parser.testCalc("{{1,2,3},{4,5,6},{7,8,9}}*{{1,2,3},{4,5,6},{7,8,9}}", variableValues, locale)
                .toString());
        answer = Objects.requireNonNull(VarCreator.createVar("{14.0,32.0,50.0}",
                variableValues)).toString();
        Assert.assertEquals(answer, parser.testCalc("{{1,2,3},{4,5,6},{7,8,9}}*{1,2,3}", variableValues, locale)
                .toString());
    }
}
