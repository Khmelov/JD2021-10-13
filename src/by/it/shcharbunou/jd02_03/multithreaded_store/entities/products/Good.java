package by.it.shcharbunou.jd02_03.multithreaded_store.entities.products;

import by.it.shcharbunou.jd02_03.multithreaded_store.exceptions.GoodException;

import java.math.BigDecimal;
import java.util.Objects;

public class Good {

    private String name;
    private BigDecimal price;

    public Good() {
        throw new GoodException("Error: Unknown good.");
    }

    public Good(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return Objects.equals(name, good.name) && Objects.equals(price, good.price);
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
