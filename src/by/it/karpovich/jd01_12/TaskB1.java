package by.it.karpovich.jd01_12;

import java.util.*;

public class TaskB1 {

    public static void main(String[] args) {
        String text = Test_jd01_12.text;
        String[] wordsArray = text.split("[^a-zA-Z']+");
        Map<String, Integer> wordsWithCountMap = new HashMap<>();
        fillWordsWithCountMap(wordsWithCountMap, wordsArray);
        printAnswer(wordsWithCountMap);
    }

    private static void printAnswer(Map<String, Integer> wordsWithCountMap) {
        for (Map.Entry<String, Integer> wordWithCount : wordsWithCountMap.entrySet()) {
            System.out.println(wordWithCount);
        }
    }

    private static void fillWordsWithCountMap(Map<String, Integer> map, String[] array) {
        for (String word : array) {
            if (!word.equals("")) {
                Integer count = map.get(word);
                if (count == null) {
                    count = 0;
                }
                map.put(word, count + 1);
            }
        }
    }
}