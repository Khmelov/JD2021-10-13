package by.it.marukovich.jd01_08.ships;

public abstract class WarShip implements Ship {
    private String name;
    private double mass;

    public WarShip(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }


    public double getMass() {
        return mass;
    }

    abstract void fight();
}
