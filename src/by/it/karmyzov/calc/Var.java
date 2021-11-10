package by.it.karmyzov.calc;


import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
  private static Map<String,Var> vars = new HashMap<>();
    static Var saveVar (String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static Var createVar (String operand) {
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (vars.containsKey(operand))
            return vars.get(operand);

        return null;
    }
    @Override
    public Var add(Var other) throws CalcExeption {
     throw new CalcExeption("Операция сложения " + this + "+" + other + " " + "невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
     throw  new CalcExeption ("Операция вычитания " + this + "-" + other + " " + "невозможна");

    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        throw  new CalcExeption ("Операция умножения " + this + "*" + other + " " + "невозможна");
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        throw  new CalcExeption("Операция деления  " + this + "/" + other + " " + "невозможна");
    }

    @Override
    public String toString() {
        return ("unknown variable (abstract stub)");

    }
}
