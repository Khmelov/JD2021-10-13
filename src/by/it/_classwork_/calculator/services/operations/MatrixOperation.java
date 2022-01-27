package by.it._classwork_.calculator.services.operations;

import by.it._classwork_.calculator.model.Matrix;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.services.abstraction.BiOperation;
import by.it._classwork_.calculator.services.abstraction.Calculable;
import by.it._classwork_.calculator.services.exceptions.CalcException;
import by.it._classwork_.calculator.services.operations.matrix.MatrixAddition;
import by.it._classwork_.calculator.services.operations.matrix.MatrixDivision;
import by.it._classwork_.calculator.services.operations.matrix.MatrixMultiplication;
import by.it._classwork_.calculator.services.operations.matrix.MatrixSubtraction;

public class MatrixOperation implements Calculable {

    @Override
    public BiOperation assignment(Var left){
        throw new CalcException("Incorrect assign with " + left);
    }

    @Override
    public BiOperation addition(Var left) {
        return new MatrixAddition((Matrix) left);
    }

    @Override
    public BiOperation division(Var left) {
        return new MatrixDivision((Matrix) left);
    }

    @Override
    public BiOperation multiplication(Var left) {
        return new MatrixMultiplication((Matrix) left);
    }

    @Override
    public BiOperation subtraction(Var left) {
        return new MatrixSubtraction((Matrix) left);
    }
}
