package by.it.ena.jd02_02.model;

import java.util.Objects;

public class Good {

    private final String name;
    private final double price;

    public Good() {
        name = "unknown Good";
        price = Double.NaN;
    }

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Good good = (Good) obj;
        return Double.compare(good.price, price) == 0 && Objects.equals(name, good.name);
    }

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
