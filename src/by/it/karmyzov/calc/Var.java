package by.it.karmyzov.calc;


import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

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
