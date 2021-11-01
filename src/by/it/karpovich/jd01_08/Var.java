package by.it.karpovich.jd01_08;

public abstract class Var implements Operation {

    @Override
    public String toString() {
        return "unknown variable (abstract stub)";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + "+" + other + " невозможна!\n");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + "-" + other + " невозможна!\n");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + "*" + other + " невозможна!\n");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " + this + "/" + other + " невозможна!\n");
        return null;
    }
}
