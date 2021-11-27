package by.it.shcharbunou.jd02_02.multithreaded_store.entities.clients;

import by.it.shcharbunou.jd02_02.multithreaded_store.exceptions.CustomerException;

import java.util.Objects;

public class Customer {

    private final int id;

    public Customer() {
        throw new CustomerException("Error: Unknown customer.");
    }

    public Customer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }
}
