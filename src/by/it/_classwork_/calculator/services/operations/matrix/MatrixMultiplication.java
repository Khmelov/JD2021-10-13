package by.it._classwork_.calculator.services.operations.matrix;

import by.it._classwork_.calculator.constants.SubStrings;
import by.it._classwork_.calculator.model.Matrix;
import by.it._classwork_.calculator.model.Scalar;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.model.Vector;
import by.it._classwork_.calculator.services.abstraction.BiOperation;
import by.it._classwork_.calculator.services.exceptions.CalcException;

public class MatrixMultiplication extends BiOperation {

    private final Matrix leftMatrix;

    public MatrixMultiplication(Matrix left) {
        super(left, SubStrings.MULTIPLY);
        this.leftMatrix = left;
    }

    @Override
    protected Var with(Scalar rightScalar) {
        double[][] values = leftMatrix.getValues();
        for (double[] row : values)
            for (int i = 0; i < row.length; i++) {
                row[i] *= rightScalar.getValue();
            }
        return new Matrix(values);
    }

    @Override
    protected Var with(Vector rightVector) {
        double[][] a = leftMatrix.getValues();
        double[] v = rightVector.getValues();
        int cols = a[0].length;
        double[] values = new double[cols];
        for (int i = 0; i < a.length; i++) {
            if (a[i].length == v.length) {
                for (int j = 0; j < a[i].length; j++) {
                    v[i] += a[i][j] * v[j];
                }
            } else {
                throw new CalcException("Incorrect size %s + %s", leftMatrix, rightVector);
            }
        }
        return new Vector(values);
    }

    @Override
    protected Var with(Matrix rightMatrix) {
        double[][] p = leftMatrix.getValues();
        double[][] q = rightMatrix.getValues();
        if (p[0].length != q.length) {
            throw new CalcException("Incorrect size %s + %s", leftMatrix, rightMatrix);
        }
        double[][] z = new double[p.length][q[0].length];
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < z[i].length; j++) {
                for (int k = 0; k < p[i].length; k++) {
                    z[i][j] += p[i][k] * q[k][j];
                }
            }
        }
        return new Matrix(z);
    }
}
