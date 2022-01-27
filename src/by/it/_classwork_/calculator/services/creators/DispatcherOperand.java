package by.it._classwork_.calculator.services.creators;

import by.it._classwork_.calculator.model.Matrix;
import by.it._classwork_.calculator.model.Scalar;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.model.Vector;
import by.it._classwork_.calculator.services.abstraction.Calculable;
import by.it._classwork_.calculator.services.exceptions.CalcException;
import by.it._classwork_.calculator.services.operations.MatrixOperation;
import by.it._classwork_.calculator.services.operations.ScalarOperation;
import by.it._classwork_.calculator.services.operations.VectorOperation;

enum DispatcherOperand {

    SCALAR(Scalar.class, new ScalarOperation()),
    VECTOR(Vector.class, new VectorOperation()),
    MATRIX(Matrix.class, new MatrixOperation()),
    ;

    private final Class<?> varClass;
    private final Calculable calculable;

    DispatcherOperand(Class<?> varClass, Calculable calculable) {
        this.varClass = varClass;
        this.calculable = calculable;
    }

    static Calculable findCalc(Var left) {
        for (DispatcherOperand value : DispatcherOperand.values()) {
            if (value.varClass.isInstance(left)) {
                return value.calculable;
            }
        }
        throw new CalcException("Not define correct operation with " + left);
    }
}
