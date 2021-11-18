package by.it.karmyzov.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAcsessFie {
    public static void main(String[] args) {
try (RandomAccessFile file = new RandomAccessFile("C:\\Users\\Mi Pro\\Desktop\\test10.txt.txt", "rw")) {
int a = file.read();
    System.out.println((char)a);
    a = file.read();
    System.out.println((char)a);
    String s = file.readLine();
    System.out.println(s);

    file.seek(file.length()-1);
    file.writeBytes("\n\t\t\t\t privet");

} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
    }
}
