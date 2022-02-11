package by.it.malyshchik.Interface.Papers;

public abstract class Notebook implements Paper {
    private String name;
    private double density;
    private int listAmount;

    public Notebook (String name, double density, int listAmount){
        this.name = name;
        this.density = density;
        this.listAmount = listAmount;
    }

    public double getDensity() {
        return density;
    }

    public int getListAmount() {
        return listAmount;
    }

    public String getName() {return name;}
    abstract void cover();
}
