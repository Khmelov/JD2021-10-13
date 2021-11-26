package by.it.marukovich.calc;

import java.util.Objects;

public class VarCreator {

    private final VarRepository varRepository;

    public VarCreator(VarRepository varRepository) {
        this.varRepository = varRepository;
    }

    Var createVar(String stringVar) throws CalcException {
        if (stringVar.matches(Patterns.SCALAR)) {
            return new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)) {
            return new Vector(stringVar);
        } else if (stringVar.matches(Patterns.MARTIX)) {
            return new Matrix(stringVar);
        } else {
            Var returnVar = varRepository.load(stringVar);
            if (Objects.isNull(returnVar)){
                throw new CalcException("Variable not found: "+stringVar);
            }
            return returnVar;
        }
    }

}
