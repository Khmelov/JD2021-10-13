package by.it.rudakova.calc.variables;

import by.it.rudakova.calc.constants.Patterns;
import by.it.rudakova.calc.exceptions.CalcException;
import by.it.rudakova.calc.repository.VarRepository;
import by.it.rudakova.calc.variables.Matrix;
import by.it.rudakova.calc.variables.Scalar;
import by.it.rudakova.calc.variables.Var;
import by.it.rudakova.calc.variables.Vector;

import java.util.Objects;

public class VarCreator {

    private final VarRepository varRepository;

    public VarCreator(VarRepository varRepository){
        this.varRepository=varRepository;
    }

   public Var createVar(String stringVar) throws CalcException {
        if(stringVar.matches(Patterns.SCALAR)){
            return new Scalar(stringVar);
        }
        else if(stringVar.matches(Patterns.VECTOR)){
            return new Vector(stringVar);
        }
        else if(stringVar.matches(Patterns.MATRIX)){
            return new Matrix(stringVar);
        }
        else{
            Var returnVar=varRepository.load(stringVar);
            if(Objects.isNull(returnVar)){
                throw new CalcException("Variable is not found: "+stringVar);
            }
            return returnVar;
        }
    }
}
