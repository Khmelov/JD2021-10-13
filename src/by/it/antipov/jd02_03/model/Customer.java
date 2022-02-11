package by.it.antipov.jd02_03.model;

import java.util.Objects;

public class Customer {
    private final String name;
    private boolean hasCart;
    boolean isWaiting;
   private ShoppingCart customerCart=new ShoppingCart();

    public ShoppingCart getCustomerCart() {
        return customerCart;
    }

    public boolean isHasCart() {
        return hasCart;
    }

    public void setHasCart(boolean hasCart) {
        this.hasCart = hasCart;
    }

    public Customer() { name="Unknown name";
    }
    public boolean isWaiting() {
        return isWaiting;
    }

    public void setWaiting(boolean waiting) {
        isWaiting = waiting;
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
    public Object getMonitor() {
        return this;
    }
}
