package by.it._classwork_.calc;

public class VarCreator {

    private final VarRepository varRepository;

    public VarCreator(VarRepository varRepository) {
        this.varRepository = varRepository;
    }

    Var createVar(String stringVar) {
        if (stringVar.matches(Patterns.SCALAR)) {
            return new Scalar(stringVar);
        } else if (stringVar.matches(Patterns.VECTOR)) {
            return new Vector(stringVar);
        } else if (stringVar.matches(Patterns.MARTIX)) {
            return new Matrix(stringVar);
        } else
            return varRepository.load(stringVar);
    }

}
