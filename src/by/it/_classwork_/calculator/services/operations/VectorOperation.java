package by.it._classwork_.calculator.services.operations;

import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.model.Vector;
import by.it._classwork_.calculator.services.abstraction.BiOperation;
import by.it._classwork_.calculator.services.abstraction.Calculable;
import by.it._classwork_.calculator.services.exceptions.CalcException;
import by.it._classwork_.calculator.services.operations.vector.VectorAddition;
import by.it._classwork_.calculator.services.operations.vector.VectorDivision;
import by.it._classwork_.calculator.services.operations.vector.VectorMultiplication;
import by.it._classwork_.calculator.services.operations.vector.VectorSubtraction;

public class VectorOperation implements Calculable {

    @Override
    public BiOperation assignment(Var left){
        throw new CalcException("Incorrect assign with " + left);
    }

    @Override
    public BiOperation addition(Var left) {
        return new VectorAddition((Vector) left);
    }

    @Override
    public BiOperation division(Var left) {
        return new VectorDivision((Vector) left);
    }

    @Override
    public BiOperation multiplication(Var left) {
        return new VectorMultiplication(left);
    }

    @Override
    public BiOperation subtraction(Var left) {
        return new VectorSubtraction(left);
    }
}
