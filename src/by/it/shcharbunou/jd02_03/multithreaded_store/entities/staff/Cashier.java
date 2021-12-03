package by.it.shcharbunou.jd02_03.multithreaded_store.entities.staff;

import java.math.BigDecimal;
import java.util.Objects;

public class Cashier {

    private final String name;
    private BigDecimal profit;

    public Cashier(int number) {
        this.name = "Cashier[" + number + "]";
    }

    public String getName() {
        return name;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cashier cashier = (Cashier) o;
        return Objects.equals(name, cashier.name) && Objects.equals(profit, cashier.profit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, profit);
    }

    @Override
    public String toString() {
        return name + " profit: " + profit;
    }
}
