package by.it.antipov.jd02_02.model;

public class Cashier {
    private final String name;
    private double revenue;


    public Cashier(int name) {
        this.name = "Cashier "+name;
    }
    public String getName(){return name;}
    public double getRevenue(){return  revenue;}

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String toString() {
        return name;
    }
}
