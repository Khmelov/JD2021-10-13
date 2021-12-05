package by.it.shcharbunou.jd02_02.multithreaded_store.entities.clients;

public class Pensioner extends Customer {

    private final int selectionRateFactor = 3 / 2;

    public Pensioner(int id) {
        super(id);
    }

    @Override
    public int getSelectionRateFactor() {
        return selectionRateFactor;
    }

    @Override
    public String toString() {
        return "Pensioner";
    }
}
