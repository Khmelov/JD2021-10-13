package by.it.shcharbunou.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        // String text = inputText();
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

    /*
    private static String inputText() {
        Scanner scanner = new Scanner(System.in);
        String temporaryText;
        boolean isChecked;
        do {
            isChecked = true;
            temporaryText = scanner.nextLine();
            if (checkEnd(temporaryText)) {
                String[] textBeforeEnd = temporaryText.split("[^a-zA-Z']+end(?![a-zA-Z])");
                if (!checkWordsCount(textBeforeEnd[0])) {
                    isChecked = false;
                }
            } else {
                isChecked = false;
            }
        } while (!isChecked);
        return temporaryText;
    }

    private static boolean checkWordsCount(String temporaryText) {
        String[] words = temporaryText.split("[^a-zA-Z']+");
        return words.length >= 100;
    }

    private static boolean checkEnd(String temporaryText) {
        String endRegex = "[^a-zA-Z']+end(?![a-zA-Z])";
        Pattern pattern = Pattern.compile(endRegex);
        Matcher matcher = pattern.matcher(temporaryText);
        return matcher.find();
    }
     */
}
