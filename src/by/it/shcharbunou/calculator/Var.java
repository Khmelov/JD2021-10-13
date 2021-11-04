package by.it.shcharbunou.calculator;

public abstract class Var implements Operation {

    @Override
    public Var add(Var other) {
        System.out.println("Error: Operation add " + this + " + " + other + " impossible!");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Error: Operation sub " + this + " - " + other + " impossible!");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Error: Operation mul " + this + " * " + other + " impossible!");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Error: Operation div " + this + " / " + other + " impossible!");
        return null;
    }

    @Override
    public String toString() {
        return "unknown variable (abstract stub)";
    }
}
