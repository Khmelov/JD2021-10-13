package by.it.marukovich.jd01_09;

import by.it._classwork_.jd01_09.Matrix;
import by.it._classwork_.jd01_09.Scalar;
import by.it._classwork_.jd01_09.Var;
import by.it._classwork_.jd01_09.Vector;

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
