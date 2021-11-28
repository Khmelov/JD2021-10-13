package by.it.shcharbunou.jd02_02.multithreaded_store.entities.clients;

import by.it.shcharbunou.jd02_02.multithreaded_store.exceptions.CustomerException;

import java.util.Objects;

public class Customer {

    private final int id;
    private final int selectionRateFactor = 1;
    private final int minGoodsCount = 1;
    private final int maxGoodsCount = 5;

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

    public int getSelectionRateFactor() {
        return selectionRateFactor;
    }

    public int getMinGoodsCount() {
        return minGoodsCount;
    }

    public int getMaxGoodsCount() {
        return maxGoodsCount;
    }
}
