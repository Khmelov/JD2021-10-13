package by.it._classwork_.jd01_08.ships;

public class Cutter extends WarShip{


    public Cutter(String name, double mass) {
        super(name, mass);
    }

    @Override
    public void move() {
        System.out.printf("Cutter %s moved very fast%n", this.getName());
    }

    @Override
    void fight() {
        System.out.printf("Cutter %s fight %n", this.getName());
    }
}
