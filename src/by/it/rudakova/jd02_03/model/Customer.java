package by.it.rudakova.jd02_03.model;

import by.it.rudakova.jd02_03.Constants;

import java.util.Objects;

public class Customer {

    private ShoppingCart cartForCustomer;

    private final String name;

    private boolean isWaiting;

    private double revenue;

    public Customer(){
        name= Constants.UNKNOWN_CUSTOMER;
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

    public ShoppingCart getShoppingCart(){
        return cartForCustomer;
    }

    public void setShoppingCart(ShoppingCart cart){
        this.cartForCustomer=cart;
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
