package by.it.karmyzov.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("[^a-zA-Z'0-9]+");
        findMapWords(scanner,words);
        printMapWords(words);


    }
    private static void printMapWords (Map<String, Integer> words) {
        for (Map.Entry<String,Integer> entry: words.entrySet()){
            System.out.println(entry.getKey()+ "=" +entry.getValue());
        }
    }
    private static void findMapWords (Scanner scanner, Map <String,Integer> words) {
        while (true) {
            String word = scanner.next();
            if(!word.equals("end")) {
                if(words.containsKey(word)) {
                    words.put(word, words.get(word) + 1);
                } else {
                    words.put(word, 1);
                }
                }else {
                    break;
                }
            }
        }
    }

//        HashMap<String, Integer> map = new HashMap<>();
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            String englishWords = scanner.nextLine();
//            if (englishWords.equals("end")) {
//                break;
//            }
//            for (String word : englishWords.split("[,.:;]"))
//                map.put(word, map.getOrDefault(word, 0) + 1);
//            System.out.println(map);
//        }
//    }
//}
