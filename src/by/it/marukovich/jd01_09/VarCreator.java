package by.it.marukovich.jd01_09;

public class VarCreator {

    static Var createVar(String stringVar) {
        if (stringVar.matches(Patterns.SCALAR)) {
            return new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)) {
            return new Vector(stringVar);
        } else if (stringVar.matches(Patterns.MARTIX)) {
            return new Matrix(stringVar);
        } else return null;
    }

}
