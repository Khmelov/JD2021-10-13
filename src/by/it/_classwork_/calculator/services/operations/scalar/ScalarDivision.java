package by.it._classwork_.calculator.services.operations.scalar;

import by.it._classwork_.calculator.constants.SubStrings;
import by.it._classwork_.calculator.model.Scalar;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.services.abstraction.BiOperation;
import by.it._classwork_.calculator.services.exceptions.CalcException;

public class ScalarDivision extends BiOperation {

    private final Scalar leftScalar;

    public ScalarDivision(Scalar left) {
        super(left, SubStrings.DIVIDE);
        this.leftScalar = left;
    }

    @Override
    protected Var with(Scalar rightScalar) {
        if (rightScalar.getValue() != 0) {
            double value = leftScalar.getValue() / rightScalar.getValue();
            return new Scalar(value);
        } else
            throw new CalcException("Division by zero");
    }

}
