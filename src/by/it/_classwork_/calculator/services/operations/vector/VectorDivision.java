    package by.it._classwork_.calculator.services.operations.vector;

    import by.it._classwork_.calculator.constants.SubStrings;
    import by.it._classwork_.calculator.model.Matrix;
    import by.it._classwork_.calculator.model.Scalar;
    import by.it._classwork_.calculator.model.Var;
    import by.it._classwork_.calculator.model.Vector;
    import by.it._classwork_.calculator.services.abstraction.BiOperation;

public class VectorDivision extends BiOperation {

    private final Vector leftVector;

    public VectorDivision(Vector left) {
        super(left, SubStrings.DIVIDE);
        this.leftVector = left;
    }

    @Override
    protected Var with(Scalar right) {
        double[] values = leftVector.getValues();
        for (int i = 0; i < values.length; i++) {
            values[i] /= right.getValue();
        }
        return new Vector(values);
    }


    @Override
    protected Var with(Matrix right) {
        return super.with(right);
    }
}
