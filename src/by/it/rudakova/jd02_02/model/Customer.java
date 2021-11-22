package by.it.rudakova.jd02_02.model;

import java.util.Objects;

public class Customer {
    private final String name;

    private boolean isWaiting;

    private double revenue;

    public Customer(){
        name="unknown customer";
    }

    public Customer(int number) {
        this.name = String.format("Customer N%d", number);
    }

    public String getName(){
        return name;
    }

    public boolean isWaiting() {
        return isWaiting;
    }

    public void setWaiting(boolean waiting) {
        isWaiting = waiting;
    }

    public double getRevenue(){
        return revenue;
    }

    public void setRevenue(double revenue){
        this.revenue=revenue;

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

    public Object getMonitor(){
        return this;
    }
}
