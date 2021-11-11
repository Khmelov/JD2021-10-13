package by.it.ena.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args){
        Map<String,Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String text;
        while (!(text = scanner.next()).equals("end")) {
            String[] words = text.split("[^a-zA-Z]+");
            for (int i=0; i<words.length;i++) {
                if (!map.containsKey(words[i])) {
                    map.put(words[i],1);
                }
                else {
                    int k = map.get(words[i]) + 1;
                    map.put(words[i], k);
                }
            }
        }
        System.out.printf(map+"\n");
        }

}
