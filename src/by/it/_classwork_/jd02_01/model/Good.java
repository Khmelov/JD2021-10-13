package by.it._classwork_.jd02_01.model;

import java.util.Objects;

public class Good {

    private final String name;
    private final double price; //BigDecimal!!!!

    @SuppressWarnings("unused")
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

    @Override
    public String toString() {
        return "Good{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
