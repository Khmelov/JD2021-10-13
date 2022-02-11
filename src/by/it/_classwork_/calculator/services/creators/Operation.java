package by.it._classwork_.calculator.services.creators;

import by.it._classwork_.calculator.model.Var;
import by.it._classwork_.calculator.services.abstraction.Calculable;
import by.it._classwork_.calculator.services.exceptions.CalcException;

import static by.it._classwork_.calculator.constants.SubStrings.*;

public class Operation {

    private final Var left;
    private final String operationSymbol;
    private final Var right;

    public Operation(Var left, String operationSymbol, Var right) {
        this.left = left;
        this.operationSymbol = operationSymbol;
        this.right = right;
    }

    public Var getResult() {
        Calculable calculable = DispatcherOperand.findCalc(left);
        return switch (operationSymbol) {
            case ASSIGN -> calculable.assignment(left).with(right);
            case PLUS -> calculable.addition(left).with(right);
            case MINUS -> calculable.subtraction(left).with(right);
            case MULTIPLY -> calculable.multiplication(left).with(right);
            case DIVIDE -> calculable.division(left).with(right);
            default -> throw new CalcException("Operation %s %s %s is not possible", left, operationSymbol, right);
        };
    }
}
