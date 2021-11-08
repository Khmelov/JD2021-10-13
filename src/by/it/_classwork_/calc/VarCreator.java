package by.it._classwork_.calc;

public class VarCreator {

    private final VarReposistory varReposistory;

    public VarCreator(VarReposistory varReposistory) {
        this.varReposistory = varReposistory;
    }

    Var createVar(String stringVar) {
        if (stringVar.matches(Patterns.SCALAR)) {
            return new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)) {
            return new Vector(stringVar);
        } else if (stringVar.matches(Patterns.MARTIX)) {
            return new Matrix(stringVar);
        } else
            return varReposistory.load(stringVar);
    }

}
