package by.it.karmyzov.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class VarCreator {

    private final VarRepository varRepository;

    public VarCreator(VarRepository varRepository) {
        this.varRepository = varRepository;
    }

    Var createVar(String stringVar) throws CalcExeption {
        if (stringVar.matches(Patterns.SCALAR)) {
            return new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)) {
            return new Vector(stringVar);
        } else {
            Var returnVar = varRepository.load(stringVar);
            if (Objects.isNull(returnVar)) {
                throw new CalcExeption("Variable not found: " + stringVar);
            }
            return returnVar;
        }
    }
}
