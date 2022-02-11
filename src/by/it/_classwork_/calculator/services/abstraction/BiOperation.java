package by.it._classwork_.calculator.services.abstraction;

import by.it._classwork_.calculator.model.Matrix;
import by.it._classwork_.calculator.model.Scalar;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.model.Vector;
import by.it._classwork_.calculator.services.exceptions.CalcException;

public abstract class BiOperation {

    private final String operationSymbol;
    private final Var left;

    public BiOperation(Var left, String operationSymbol) {
        this.left = left;
        this.operationSymbol = operationSymbol;
    }


    public Var with(Var right) {
        if (right instanceof Scalar rightCasted) return with(rightCasted);
        if (right instanceof Vector rightCasted) return with(rightCasted);
        if (right instanceof Matrix rightCasted) return with(rightCasted);
        throw new CalcException(String.format("Unknown value %s", right));
    }

    //Overload main method - with
    protected Var with(Scalar right) {
        throw new CalcException(
                String.format("Scalar operation (%s %s %s) is not possible",
                        left, operationSymbol, right
                )
        );
    }

    protected Var with(Vector right) {
        throw new CalcException(
                String.format("Vector operation (%s %s %s) is not possible",
                        left, operationSymbol, right
                )
        );
    }

    protected Var with(Matrix right) {
        throw new CalcException(
                String.format("Matrix operation (%s %s %s) is not possible",
                        left, operationSymbol, right
                )
        );
    }


}
