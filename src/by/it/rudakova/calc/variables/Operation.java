package by.it.rudakova.calc.variables;

import by.it.rudakova.calc.exceptions.CalcException;
import by.it.rudakova.calc.variables.Var;

public interface Operation {
    Var add(Var other) throws CalcException;

    Var sub(Var other) throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}
