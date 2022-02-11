package by.it.antipov.jd01_09;

public class VarCreator { static Var createVar (String stringVar) {
    if (stringVar.matches(Patterns.SCALAR)) {return new Scalar(stringVar);}
    if (stringVar.matches(Patterns.VECTOR)) {return new Vector(stringVar);}
   if (stringVar.matches(Patterns.MATRIX)) {return new Matrix(stringVar);}
    return  null;}
}
