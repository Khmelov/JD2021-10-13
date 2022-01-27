package by.it._classwork_.calculator.services.creators;

import by.it._classwork_.calculator.constants.Patterns;
import by.it._classwork_.calculator.model.Matrix;
import by.it._classwork_.calculator.model.Scalar;
import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.model.Vector;
import by.it._classwork_.calculator.services.VarRepository;
import by.it._classwork_.calculator.services.exceptions.CalcException;

public class VarCreator {

    public Var createVar(String stringVar) {
        stringVar = stringVar.replaceAll("\\s*", "");
        if (stringVar.matches(Patterns.SCALAR)) {
            return new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)) {
            return new Vector(stringVar);
        } else if (stringVar.matches(Patterns.MATRIX)) {
            return new Matrix(stringVar);
        } else if (stringVar.matches(Patterns.VARNAME)) {
            Var variable = VarRepository.find(stringVar);
            if  (variable != null){
                return variable;
            }
        }
        throw new CalcException("Unknown expression " + stringVar);
    }
}
