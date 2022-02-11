package by.it.shcharbunou.calc;

import java.util.Map;

import static by.it.shcharbunou.calc.Samples.*;

public class VarCreator {

    protected static Var createVar(String stringOperand, Map<String, Var> values) {
        if (stringOperand.matches(SCALAR)) {
            return new Scalar(stringOperand);
        } else if (stringOperand.matches(VECTOR)) {
            return new Vector(stringOperand);
        } else if (stringOperand.matches(MATRIX)) {
            return new Matrix(stringOperand);
        } else if (stringOperand.matches(VARIABLE)){
            return createVar(values.get(stringOperand).toString(), values);
        }
        return null;
    }
}
