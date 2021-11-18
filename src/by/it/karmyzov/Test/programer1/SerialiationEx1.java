package by.it.karmyzov.Test.programer1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerialiationEx1 {
    public static void main(String[] args) {
        List<String> emp = new ArrayList<>();
        emp.add("Zaur");
        emp.add("Ivan");
        emp.add("Elena");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream("C:\\Users\\Mi Pro\\Desktop\\employers.bin"));

        ) {
            outputStream.writeObject(emp);
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
