package by.it._classwork_.calculator.services.operations;

import by.it._classwork_.calculator.model.Scalar;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.services.abstraction.BiOperation;
import by.it._classwork_.calculator.services.abstraction.Calculable;
import by.it._classwork_.calculator.services.exceptions.CalcException;
import by.it._classwork_.calculator.services.operations.scalar.ScalarAddition;
import by.it._classwork_.calculator.services.operations.scalar.ScalarDivision;
import by.it._classwork_.calculator.services.operations.scalar.ScalarMultiplication;
import by.it._classwork_.calculator.services.operations.scalar.ScalarSubtraction;

public class ScalarOperation implements Calculable {

    @Override
    public BiOperation assignment(Var left){
        throw new CalcException("Incorrect assign with " + left);
    }
    @Override
    public BiOperation addition(Var left) {
        return new ScalarAddition((Scalar) left);
    }

    @Override
    public BiOperation division(Var left) {
        return new ScalarDivision((Scalar) left);
    }

    @Override
    public BiOperation multiplication(Var left) {
        return new ScalarMultiplication((Scalar) left);
    }

    @Override
    public BiOperation subtraction(Var left) {
        return new ScalarSubtraction((Scalar) left);
    }
}
