package by.it.rudakova.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] wordsArray = {};
    private static int[] numberRepeatedWords = {};

    private static int searchPosition(String word) {
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(word))
                return i;
        }
        return -1;

    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёË]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            int position = searchPosition(word);
            if (position >= 0) {
                numberRepeatedWords[position]++;
            } else {
                int last = wordsArray.length;
                wordsArray = Arrays.copyOf(wordsArray, last + 1);
                wordsArray[last] = word;
                numberRepeatedWords = Arrays.copyOf(numberRepeatedWords, last + 1);
                numberRepeatedWords[last] = 1;
            }
        }
        for (int i = 0; i < wordsArray.length; i++) {
            System.out.println(wordsArray[i] + "=" + numberRepeatedWords[i]);
        }
    }
}

