package by.it._classwork_.calculator.services.abstraction;

import by.it._classwork_.calculator.model.Var;

public interface Calculable {
    BiOperation assignment(Var left);

    BiOperation addition(Var left);

    BiOperation division(Var left);

    BiOperation multiplication(Var left);

    BiOperation subtraction(Var left);
}
