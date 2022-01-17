package by.it.shcharbunou.calc;

import static by.it.shcharbunou.jd01_09.Samples.*;

public class VarCreator {

    protected static Var createVar(String stringOperand) {
        if (stringOperand.matches(SCALAR)) {
            return new Scalar(stringOperand);
        } else if (stringOperand.matches(VECTOR)) {
            return new Vector(stringOperand);
        } else if (stringOperand.matches(MATRIX)) {
            return new Matrix(stringOperand);
        } else {
            return null;
        }
    }
}
