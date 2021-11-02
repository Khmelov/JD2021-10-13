package by.it.karmyzov.jd01_08.films;

abstract class Nativefilm implements Film {
    private String name;
    private double time;
    private int year;

public Nativefilm (String name, double time, int year) {
    this.name = name;
    this.time=time;
    this.year=year;

}
public String getName () {return name;}
public double getTime () {return time;}
public int getYear() {return year;}
public abstract void show();

}
