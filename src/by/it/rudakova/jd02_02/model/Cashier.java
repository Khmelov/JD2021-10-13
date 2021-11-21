package by.it.rudakova.jd02_02.model;

public class Cashier {
    private String name;
    private double revenue;

    public Cashier(int number){
        name="Cashier №"+number;
    }

    public String getName() {
        return name;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    @Override
    public String toString() {
        return String.format("%s[sum:%f]",name,revenue);
    }
}
