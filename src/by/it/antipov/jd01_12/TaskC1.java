package by.it.antipov.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        Random random = new Random();
        int randomInt;
        Map<Integer,String> cipherL = new HashMap<>();
        Map<Integer,String> cipherS = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        recording(random, cipherL, scanner);
        System.out.println(cipherL);
        for (Map.Entry<Integer,String> entry:
             cipherL.entrySet()) {if(!cipherS.containsValue(entry.getValue())){cipherS.put(entry.getKey(),entry.getValue());}

        }
        System.out.println(cipherS);

    }

    private static void recording(Random random, Map<Integer, String> cipherL, Scanner scanner) {
        int randomInt;
        for (;;){
            String word = scanner.nextLine();
            if (Objects.equals(word, "end")){break;}else {
                randomInt= random.nextInt();
               while (cipherL.containsKey(randomInt)) {
                   randomInt= random.nextInt();
               }
                cipherL.put(randomInt,word);
            }
        }
    }
}
