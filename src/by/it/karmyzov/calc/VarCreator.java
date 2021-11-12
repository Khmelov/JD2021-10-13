package by.it.karmyzov.calc;

public class VarCreator {
    public static Var createVar(String stringVar) throws CalcExeption {
        if (stringVar.matches(Patterns.SCALAR)) {
                return new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)) {
            return new Vector(stringVar);
        }else throw  new CalcExeption("Невозможно создать" +stringVar);
        }
    }

