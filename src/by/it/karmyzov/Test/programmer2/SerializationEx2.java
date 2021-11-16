package by.it.karmyzov.Test.programmer2;

import by.it.karmyzov.Test.programer1.Employee;

import java.io.*;

public class SerializationEx2 {
    public static void main(String[] args) {
        Employee bestEmployee;
        try (ObjectInputStream inputStream = new ObjectInputStream(
                new FileInputStream("C:\\Users\\Mi Pro\\Desktop\\employers2.bin"))
        ) {
            bestEmployee = (Employee) inputStream.readObject();
            System.out.println(bestEmployee);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
