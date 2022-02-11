package by.it._classwork_.calculator.services.operations.scalar;

import by.it._classwork_.calculator.constants.SubStrings;
import by.it._classwork_.calculator.model.Matrix;
import by.it._classwork_.calculator.model.Scalar;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.model.Vector;
import by.it._classwork_.calculator.services.abstraction.BiOperation;

public class ScalarMultiplication extends BiOperation {

    private final Scalar leftScalar;

    public ScalarMultiplication(Scalar left) {
        super(left, SubStrings.MULTIPLY);
        this.leftScalar = left;
    }

    @Override
    protected Var with(Scalar rightScalar) {
        double value = leftScalar.getValue() * rightScalar.getValue();
        return new Scalar(value);
    }

    @Override
    protected Var with(Vector rightVector) {
        double[] values = rightVector.getValues();
        for (int i = 0; i < values.length; i++) {
            values[i] *= leftScalar.getValue();
        }
        return new Vector(values);
    }

    @Override
    protected Var with(Matrix rightMatrix) {
        double[][] values = rightMatrix.getValues();
        for (double[] row : values) {
            for (int i = 0; i < row.length; i++) {
                row[i] *= leftScalar.getValue();
            }
        }
        return new Matrix(values);
    }
}
