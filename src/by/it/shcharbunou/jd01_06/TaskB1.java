package by.it.shcharbunou.jd01_06;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        String regex = "[а-яА-ЯёЁ]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        ArrayList<String> trueWords = new ArrayList<>();
        findTrueWords(matcher, trueWords);
        printTrueWords(trueWords);
    }

    private static void findTrueWords(Matcher matcher, ArrayList<String> trueWords) {
        int firstLetterPosition = 0;
        int lastLetterPosition;
        while (matcher.find()) {
            lastLetterPosition = matcher.group().length() - 1;
            if (!checkVowel(matcher.group(), firstLetterPosition) && checkVowel(matcher.group(), lastLetterPosition)) {
                trueWords.add(matcher.group());
            }
        }
    }

    private static boolean checkVowel(String word, int position) {
        return switch (word.charAt(position)) {
            case 'а', 'о', 'у', 'э', 'ы', 'я', 'ё', 'е', 'ю', 'и', 'А', 'О', 'У', 'Э', 'Ы', 'Я', 'Ë', 'Е', 'Ю', 'И' -> true;
            default -> false;
        };
    }

    private static void printTrueWords(ArrayList<String> trueWords) {
        for (String trueWord : trueWords) {
            System.out.println(trueWord);
        }
    }
}
