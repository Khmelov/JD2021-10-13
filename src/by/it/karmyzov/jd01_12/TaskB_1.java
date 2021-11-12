package by.it.karmyzov.jd01_12;

import java.util.*;

public class TaskB_1 {

        public static void main(String[] args) {
            StringBuilder stringBuilder = new StringBuilder();
            Scanner scanner = new Scanner(System.in);
            String words;
            while (true) {
                words = scanner.nextLine();
                if (words.equals("end")) {
                    break;
                }

                stringBuilder.append(words);
            }
            words = stringBuilder.toString();
            words = words.replaceAll("[^a-zA-Z'\s]+", "");
            String[] englishWordsArray = words.split("\\s+");
            List<String> wordsList = Arrays.asList(englishWordsArray);
            Map<String, Integer> wordsMap = new HashMap<>();

            for (String element : wordsList) {
                if (!wordsMap.containsKey(element)) {
                    wordsMap.put(element, 1);
                } else {
                    wordsMap.put(element, wordsMap.get(element) + 1);
                }
            }

            for (String element : wordsMap.keySet()) {
                System.out.println(element + "=" + wordsMap.get(element));
            }
        }
    }
