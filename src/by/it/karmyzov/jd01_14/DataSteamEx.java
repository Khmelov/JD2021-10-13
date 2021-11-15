package by.it.karmyzov.jd01_14;

import java.io.*;

public class DataSteamEx {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("C:\\Users\\Mi Pro\\Desktop\\my_test.bin"));
             DataInputStream dim = new DataInputStream(new FileInputStream("C:\\Users\\Mi Pro\\Desktop\\my_test.bin"))
                ) {
            dos.writeBoolean(true);
            dos.writeByte(5);
            dos.writeInt(7);
            dos.writeLong(1000000);
            dos.writeFloat(3.2f);
            dos.writeDouble(123.221);
            System.out.println(dim.readBoolean());
            System.out.println(dim.readByte());
            System.out.println(dim.readInt());
            System.out.println(dim.readLong());
            System.out.println(dim.readFloat());
            System.out.println(dim.readDouble());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}