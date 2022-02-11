package by.it.oliakhevich.jd02_03.model;

import java.util.Objects;

public class Good {
    private final String name;
    private final double price;

    public Good() {
        this.name="unknown name";
        this.price=Double.NaN;
    }

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return Double.compare(good.price, price) == 0 && Objects.equals(name, good.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return   name + ", price=" + price;
    }
}
