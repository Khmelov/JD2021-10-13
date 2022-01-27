package by.it._classwork_.calculator.services.operations.vector;

import by.it._classwork_.calculator.constants.SubStrings;
import by.it._classwork_.calculator.model.Matrix;
import by.it._classwork_.calculator.model.Scalar;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.model.Vector;
import by.it._classwork_.calculator.services.abstraction.BiOperation;
import by.it._classwork_.calculator.services.exceptions.CalcException;

public class VectorMultiplication extends BiOperation {

    private final Vector leftVector;

    public VectorMultiplication(Var left) {
        super(left, SubStrings.MULTIPLY);
        this.leftVector = (Vector) left;
    }

    @Override
    protected Var with(Scalar right) {
        double[] values = leftVector.getValues();
        for (int i = 0; i < values.length; i++) {
            values[i] *= right.getValue();
        }
        return new Vector(values);
    }

    @Override
    protected Var with(Vector right) {
        double[] leftValues = leftVector.getValues();
        double[] rightValues = right.getValues();
        if (leftValues.length != rightValues.length) {
            throw new CalcException("Incorrect size: %s * %s", leftVector, right);
        }
        ;
        double result = 0;
        for (int i = 0; i < leftValues.length; i++) {
            result += leftValues[i] * rightValues[i];
        }
        return new Scalar(result);
    }

    @Override
    protected Var with(Matrix right) {
        return super.with(right);
    }
}
