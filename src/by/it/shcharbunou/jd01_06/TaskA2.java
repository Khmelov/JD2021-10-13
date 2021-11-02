package by.it.shcharbunou.jd01_06;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        String regex = "[а-яА-ЯёЁ]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> wordsCount = new ArrayList<>();
        fillArraysWithWordsAndCounts(matcher, words, wordsCount);
        printWordsAndCounts(words, wordsCount);
    }

    private static void fillArraysWithWordsAndCounts(Matcher matcher, ArrayList<String> words, ArrayList<Integer> wordsCount) {
        while (matcher.find()) {
            if (!(words.contains(matcher.group()))) {
                words.add(matcher.group());
                wordsCount.add(1);
            } else {
                wordsCount.set(words.indexOf(matcher.group()), wordsCount.get(words.indexOf(matcher.group())) + 1);
            }
        }
    }

    private static void printWordsAndCounts(ArrayList<String> words, ArrayList<Integer> wordsCount) {
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i) + "=" + wordsCount.get(i));
        }
    }
}
