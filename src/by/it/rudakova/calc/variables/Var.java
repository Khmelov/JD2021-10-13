package by.it.rudakova.calc.variables;

import by.it.rudakova.calc.exceptions.CalcException;
import by.it.rudakova.calc.constants.Patterns;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {

    private static Map<String,Var> vars=new HashMap<>();

    static Var saveVar(String name, Var var){
        vars.put(name,var);
        return var;

    }

    static Var createVar(String operand) throws CalcException {
        operand=operand.trim().replace("\\s+","");
        if(operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if(operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if(operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        if(vars.containsKey(operand))
            return vars.get(operand);
        throw new CalcException("Невозможно создать "+operand);
    }

    @Override
    public Var add(Var other) throws CalcException{
       throw new CalcException("Операция сложения " + this + "+" + other + " невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException("Операция вычетания " + this + "-" + other + " невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException("Операция умножения " + this + "*" + other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + "/" + other + " невозможна");
    }
}
