package by.it.karmyzov.jd01_08.ships;

public class Runner {

    public static void main(String[] args) {

        WarShip[] warShips = {
                new Cruiser("Queen Mary", 100000),
                new Cruiser("Aurora", 100000),
                new Cutter("Faster", 100000),
                new Cutter("Small bot", 100000),
        };


        for (WarShip warShip : warShips) {
            warShip.move();
            warShip.fight();
        }
    }
}
