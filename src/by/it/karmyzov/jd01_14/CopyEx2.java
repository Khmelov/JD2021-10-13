package by.it.karmyzov.jd01_14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyEx2 {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("C:\\Users\\Mi Pro\\Desktop\\hi.jpg");
             FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Mi Pro\\Desktop\\hi1.jpg");
                ) {
            int i;
            while ((i=inputStream.read())!=-1) {
                outputStream.write(i);
            }
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}