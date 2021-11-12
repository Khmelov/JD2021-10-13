package by.it.karmyzov.jd01_12;

import java.util.HashMap;
import java.util.Scanner;

public class TaskB1 {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String words = sc.nextLine();
            if (words.equals("end")) {
                break;
            }
            for (String word : words.split("[,.:; ]"))
                map.put(word, map.getOrDefault(word, 0) + 1);
            System.out.println(map);
        }

    }
}
