package by.it.antipov.jd02_01.model;

import java.util.Objects;

public class Customer {
    private final String name;
    private boolean hasCart;

    public boolean isHasCart() {
        return hasCart;
    }

    public void setHasCart(boolean hasCart) {
        this.hasCart = hasCart;
    }

    public Customer() { name="Unknown name";
    }

    public Customer(int number) {
        this.name = String.format("Customer %d",number);
    }

    public String getName() {
        return name;
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
}
