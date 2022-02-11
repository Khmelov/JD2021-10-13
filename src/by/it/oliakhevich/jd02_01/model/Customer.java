package by.it.oliakhevich.jd02_01.model;

import java.util.Objects;

public class Customer {

    private final String name;


    public Customer() {
        name = "unknown customer";
    }

    public Customer(int number) {
        this.name = String.format("Customer N%d", number);
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



