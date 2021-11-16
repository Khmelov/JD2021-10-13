package by.it.karmyzov.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathEx {
    public static void main(String[] args) {
        Path filePath = Paths.get( "test15.txt");
        Path directryPath = Paths.get( "C:\\Users\\Mi Pro\\Desktop\\m");

        System.out.println(filePath.getFileName());
        System.out.println(directryPath.getFileName());
        System.out.println("-----------------------------------");
        System.out.println(filePath.getParent());
        System.out.println(directryPath.getParent());
        System.out.println("-----------------------------------");
        System.out.println(filePath.getRoot());
        System.out.println(directryPath.getRoot());
        System.out.println("-----------------------------------");
        System.out.println(filePath.isAbsolute());
        System.out.println(directryPath.isAbsolute());
        System.out.println("-----------------------------------");
        System.out.println(filePath.toAbsolutePath());
        System.out.println(directryPath.toAbsolutePath());
        System.out.println("-----------------------------------");
        System.out.println(filePath.toAbsolutePath().getParent());
        System.out.println(directryPath.toAbsolutePath().getParent());
        System.out.println("-----------------------------------");

        System.out.println(directryPath.resolve(filePath));

    }
}
