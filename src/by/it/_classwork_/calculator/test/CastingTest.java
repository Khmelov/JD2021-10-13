package by.it._classwork_.calculator.test;

import by.it._classwork_.calculator.model.Scalar;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.services.abstraction.BiOperation;
import by.it._classwork_.calculator.services.operations.scalar.ScalarAddition;
import org.junit.Assert;
import org.junit.Test;

public class CastingTest {

    @Test
    public void checkCasting() {
        Scalar var1 = new Scalar(1);
        Var var2 = new Scalar(2);
        BiOperation operation = new ScalarAddition(var1);
        Var result = operation.with(var2);
        Assert.assertEquals("3.0", result.toString());
    }
}
