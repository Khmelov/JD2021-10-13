package by.it.antipov.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskC1 {
    public static void main(String[] args) {
        Map<String,Integer> cipher = new HashMap<>();
        cipher.put("Kirill",1);
        cipher.put("walking",2);
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        System.out.println(cipher);

//text.split()
    }
}
