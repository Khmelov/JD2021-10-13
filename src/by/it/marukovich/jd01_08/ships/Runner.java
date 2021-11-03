package by.it.marukovich.jd01_08.ships;

public class Runner {
    public static void main(String[] args) {
        WarShip[] warShips = {
                new Cruiser("Queen Mary", 100000),
        new Cruiser("Aurora", 120000),
        new Cutter("Sparrow", 50000),
        new Cutter("Sabbot", 90000),
        };
        for (WarShip warShip:warShips){
            warShip.move();
            warShip.fight();
        }
    }
}
