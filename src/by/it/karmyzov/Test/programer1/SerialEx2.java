package by.it.karmyzov.Test.programer1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerialEx2 {
    public static void main(String[] args) {
        Car car = new Car("nissan" , "white");
        Employee employee = new Employee("Mariya","Vasina", "minsk",
//                29,
           500.44, car);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("C:\\Users\\Mi Pro\\Desktop\\employers2.bin"))

        ) {
            outputStream.writeObject(employee);
            System.out.println("Done");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
