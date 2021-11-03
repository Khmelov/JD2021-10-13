package by.it.shcharbunou.jd01_09;

public class VarCreator {

    protected static Var createVar(String stringOperand) {
        if (stringOperand.matches(Samples.SCALAR)) {
            return new Scalar(stringOperand);
        } else if (stringOperand.matches(Samples.VECTOR)) {
            return new Vector(stringOperand);
        } else if (stringOperand.matches(Samples.MATRIX)) {
            return new Matrix(stringOperand);
        } else {
            return null;
        }
    }
}
