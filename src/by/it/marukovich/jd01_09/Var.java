package by.it.marukovich.jd01_09;

public abstract class Var implements Operation {


    @Override
    public Var add(Var other){
        System.out.printf("Operation %s + %s not supported", this, other);
        return null;
    }
    @Override
    public Var sub(Var other){
        System.out.printf("Operation %s - %s not supported", this, other);
        return null;
    }
    @Override
    public Var mul(Var other){
        System.out.printf("Operation %s * %s not supported", this, other);
        return null;
    }
    @Override
    public Var div(Var other){
        System.out.printf("Operation %s / %s not supported", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "Unknown variable (abstract stub)";
    }
}
