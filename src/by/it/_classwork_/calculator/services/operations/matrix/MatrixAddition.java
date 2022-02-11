package by.it._classwork_.calculator.services.operations.matrix;

import by.it._classwork_.calculator.model.Matrix;
import by.it._classwork_.calculator.model.Scalar;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.services.abstraction.BiOperation;
import by.it._classwork_.calculator.services.exceptions.CalcException;

import static by.it._classwork_.calculator.constants.SubStrings.PLUS;

public class MatrixAddition extends BiOperation {

    private final Matrix leftMatrix;

    public MatrixAddition(Matrix left) {
        super(left, PLUS);
        this.leftMatrix = left;
    }

    @Override
    protected Var with(Scalar rightScalar) {
        double[][] values = leftMatrix.getValues();
        for (double[] row : values) {
            for (int i = 0; i < row.length; i++) {
                row[i] += rightScalar.getValue();
            }
        }
        return new Matrix(values);
    }

    @Override
    protected Var with(Matrix rightMatrix) {
        double[][] p = leftMatrix.getValues();
        double[][] q = rightMatrix.getValues();
        for (int i = 0; i < p.length; i++) {
            if (p.length == q.length && p[i].length == q[i].length) {
                for (int j = 0; j < p[i].length; j++) {
                    p[i][j] += q[i][j];
                }
            } else {
                throw new CalcException("Incorrect size %s + %s", leftMatrix, rightMatrix);
            }
        }
        return new Matrix(p);
    }
}
