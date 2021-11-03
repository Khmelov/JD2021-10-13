package by.it.marukovich.jd01_08.ships;

public class Cruiser extends WarShip {
    public Cruiser(String name, double mass) {
        super(name, mass);
    }

    @Override
    public void move() {
        System.out.printf("%s moved%n", this);
    }

    @Override
    void fight() {
        System.out.printf("%s fight%n", this);
    }

    @Override
    public String toString() {
        return String.format("Cruiser %s",this.getName());
    }
}
