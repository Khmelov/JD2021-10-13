package by.it.shcharbunou.jd02_01.multithreaded_store.entities.products;

import java.math.BigDecimal;

public class Good {
    private String name;
    private BigDecimal price;

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
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.hashCode() != obj.hashCode()) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        return this.price.compareTo(((Good) obj).getPrice()) == 0 && this.name.equals(((Good) obj).getName());
    }

    @Override
    public String toString() {
        return "Good:\nName:" + this.name + "Price:" + this.price + "\n";
    }
}
