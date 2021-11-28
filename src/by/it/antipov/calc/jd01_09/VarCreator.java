package by.it.antipov.calc.jd01_09;

import java.util.Objects;

public class VarCreator { static Var createVar (String stringVar) throws CalcException {
    VarRepository varGetter =new VarRepository();
    if (stringVar.matches(Patterns.SCALAR)) {return new Scalar(stringVar);}
    else if (stringVar.matches(Patterns.VECTOR)) {return new Vector(stringVar);}
    else if (stringVar.matches(Patterns.MATRIX)) {return new Matrix(stringVar);}
    else {
       Var var= varGetter.giveVar(stringVar);
        //if (Objects.isNull(var)){throw new CalcException("There is no such variable");}
        return var ;}
    }
}
