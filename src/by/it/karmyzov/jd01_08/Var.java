package by.it.karmyzov.jd01_08;

abstract class Var  implements Operation{
    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения ");
        return null;
    }

    @Override
    public Var sub(Var other) {
        return null;
    }

    @Override
    public Var mul(Var other) {
        return null;
    }

    @Override
    public Var div(Var other) {
        return null;
    }

    @Override
    public String toString() {
        return ("unknown variable (abstract stub)");

    }
}
