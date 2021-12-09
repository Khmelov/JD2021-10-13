package by.it.rudakova.finaltask.task3;

import by.it._classwork_.jd01_15.RepositoryException;
import by.it.rudakova.calc.helpers.PathFinder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {
        List<Car> carList=new ArrayList<>();
        for(int i=0;i<10;i++){
            carList.add(Car.createRandomCar());
        }

        for(Car item:carList){
            System.out.println(item.getName()+", модель "+item.getCarModel()+", двигатель "+item.engineCapacity);
        }

        List<Car> engineCapacity1=new ArrayList<>();
        List<Car> engineCapacity2=new ArrayList<>();
        List<Car> engineCapacity3=new ArrayList<>();

        Map<Integer,List<Car>> mapCars=new HashMap<>();

        for(int i=0;i<carList.size();i++){
            if(carList.get(i).getEngineCapacity()==1){
                engineCapacity1.add(carList.get(i));
            }
            else if (carList.get(i).getEngineCapacity()==2){
                engineCapacity2.add(carList.get(i));
            }
            else if (carList.get(i).getEngineCapacity()==3){
                engineCapacity3.add(carList.get(i));
            }
        }
        System.out.println();

        for(Car item:engineCapacity1){
            System.out.println(item.getName()+", модель "+item.getCarModel()+", двигатель "+item.engineCapacity);
        }
        System.out.println();

        for(Car item:engineCapacity2){
            System.out.println(item.getName()+", модель "+item.getCarModel()+", двигатель "+item.engineCapacity);
        }
        System.out.println();

        for(Car item:engineCapacity3){
            System.out.println(item.getName()+", модель "+item.getCarModel()+", двигатель "+item.engineCapacity);
        }

        mapCars.put(1,engineCapacity1);
        mapCars.put(2,engineCapacity2);
        mapCars.put(3,engineCapacity3);

        PathFinder pathFinder = new PathFinder();
        String fileName = pathFinder.getStringPath(Car.class, "carList.txt");
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            for (Car item : engineCapacity2) {
                printWriter.println(item.getName()+", модель "+item.getCarModel()+", двигатель "+item.engineCapacity);
            }
        } catch (IOException e) {
            System.out.println("Oшибка ввода-выводы");
        }
    }
}
