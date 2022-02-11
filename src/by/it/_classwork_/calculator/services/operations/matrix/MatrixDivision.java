package by.it._classwork_.calculator.services.operations.matrix;

import by.it._classwork_.calculator.constants.SubStrings;
import by.it._classwork_.calculator.model.Matrix;
import by.it._classwork_.calculator.model.Scalar;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.services.abstraction.BiOperation;

public class MatrixDivision extends BiOperation {

    private final Matrix leftMatrix;

    public MatrixDivision(Matrix left) {
        super(left, SubStrings.DIVIDE);
        this.leftMatrix = left;
    }

    @Override
    protected Var with(Scalar rightScalar) {
        double[][] values = leftMatrix.getValues();
        for (double[] row : values) {
            for (int i = 0; i < row.length; i++) {
                row[i] /= rightScalar.getValue();
            }
        }
        return new Matrix(values);
    }


}
