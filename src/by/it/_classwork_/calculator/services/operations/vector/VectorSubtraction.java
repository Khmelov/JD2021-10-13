package by.it._classwork_.calculator.services.operations.vector;

import by.it._classwork_.calculator.constants.SubStrings;
import by.it._classwork_.calculator.model.Matrix;
import by.it._classwork_.calculator.model.Scalar;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.model.Vector;
import by.it._classwork_.calculator.services.abstraction.BiOperation;
import by.it._classwork_.calculator.services.exceptions.CalcException;

public class VectorSubtraction extends BiOperation {

    private final Vector leftVector;

    public VectorSubtraction(Var left) {
        super(left, SubStrings.MINUS);
        this.leftVector = (Vector) left;
    }

    @Override
    protected Var with(Scalar right) {
        double[] values = leftVector.getValues();
        for (int i = 0; i < values.length; i++) {
            values[i] -= right.getValue();
        }
        return new Vector(values);
    }

    @Override
    protected Var with(Vector right) {
        double[] result = leftVector.getValues();
        double[] rightValues = right.getValues();
        if (result.length != rightValues.length) {
            throw new CalcException("Incorrect size: %s - %s", leftVector, right);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] += rightValues[i];
        }
        return new Vector(result);
    }

    @Override
    protected Var with(Matrix right) {
        return super.with(right);
    }
}
