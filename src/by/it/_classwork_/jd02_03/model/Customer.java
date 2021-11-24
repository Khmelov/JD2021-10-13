package by.it._classwork_.jd02_03.model;

import by.it._classwork_.jd02_03.Constants;

import java.util.Objects;

public class Customer {

    private final String name;

    private boolean isWaiting;

    private double total;


    @SuppressWarnings("unused")
    public Customer() {
        name = Constants.UNKNOWN_CUSTOMER;
    }

    public Customer(int number) {
        this.name = String.format("Customer №%d", number);
    }

    public String getName() {
        return name;
    }

    public boolean isWaiting() {
        return isWaiting;
    }

    public void setWaiting(boolean waiting) {
        isWaiting = waiting;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public Object getMonitor() {
        return this;
    }
}
