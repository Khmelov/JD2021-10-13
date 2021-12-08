package by.it.rudakova.finaltask.task3;

import by.it._classwork_.jd01_15.RepositoryException;
import by.it.rudakova.calc.helpers.PathFinder;
import by.it.rudakova.calc.repository.VarRepository;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Car {
    String name;
    private CarModel carModel;
    int engineCapacity;

    public CarModel getCarModel(){
        return carModel;
    }

    public void setCarModel(CarModel carModel){
        this.carModel=carModel;
    }

    public int getEngineCapacity(){
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity){
        this.engineCapacity=engineCapacity;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public static Car createRandomCar(){
        Car result = new Car();

        int firstRandom = (int) (Math.random()*3);
        int secondRandom = (int) (Math.random()*3);
        int thirdRandom = (int) ((Math.random()*3)+1);

        switch (firstRandom){
            case 0:
                result.setName("BMW");
                break;
            case 1:
                result.setName("KIA");
                break;
            case 2:
                result.setName("HUNDA");
                break;
        }

        switch (secondRandom){
            case 0:
                result.setCarModel(CarModel.CROSSOVER);
                break;
            case 1:
                result.setCarModel(CarModel.HATCHBACK);
                break;
            case 2:
                result.setCarModel(CarModel.SEDAN);
                break;
        }

        result.setEngineCapacity(thirdRandom);
        return result;
    }

}
