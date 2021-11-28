package by.it.rudakova.jd02_03.model;

import by.it.rudakova.jd02_03.Constants;

import java.util.Objects;

public class Goods {

    private final String name;
    private final double price;

    public Goods(){
        name= Constants.UNKNOWN_PRODUCT;
        price=Double.NaN;
    }

    public Goods(String name, double price){
        this.name=name;
        this.price=price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Double.compare(goods.price, price) == 0 && Objects.equals(name, goods.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
