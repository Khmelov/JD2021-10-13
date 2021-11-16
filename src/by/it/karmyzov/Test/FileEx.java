package by.it.karmyzov.Test;

import java.io.File;

public class FileEx {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Mi Pro\\Desktop\txt2.txt");
        File folder = new File("C:\\Users\\Mi Pro\\Desktop\\a");
        System.out.println(file.getAbsolutePath()+"\n" +folder.getAbsolutePath());
        System.out.println(file.isAbsolute());
        System.out.println(folder.isAbsolute());
        System.out.println(file.isDirectory());
        System.out.println(folder.isDirectory());
        System.out.println(folder.length());
        System.out.println(file.length());
        System.out.println(file.delete());
        folder.delete();
        System.out.println( file.getTotalSpace());
        System.out.println(file.canWrite());
        System.out.println(file.canRead());



    }
}
