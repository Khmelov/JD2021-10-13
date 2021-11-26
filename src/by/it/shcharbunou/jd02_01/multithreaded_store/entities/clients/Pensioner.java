package by.it.shcharbunou.jd02_01.multithreaded_store.entities.clients;

import by.it.shcharbunou.jd02_01.multithreaded_store.exceptions.CustomerException;

import java.util.Objects;

public class Pensioner extends Customer {

    private final int id;

    public Pensioner() {
        throw new CustomerException("Error: Unknown customer.");
    }

    public Pensioner(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pensioner pensioner = (Pensioner) o;
        return id == pensioner.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pensioner{" +
                "id=" + id +
                '}';
    }
}
