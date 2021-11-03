package by.it.karmyzov.jd01_0901;

public class VarCreator {
    static Var createVar(String stringVar) {
        if (stringVar.matches(Patterns.SCALAR)) {
            return new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)) {
            return new Vector(stringVar);
        } else return null;
    }
}

