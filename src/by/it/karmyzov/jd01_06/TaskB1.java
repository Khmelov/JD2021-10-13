package by.it.karmyzov.jd01_06;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TaskB1 {
    private static final String VOTES = "ёуеэоаыяию" + "ёуеэоаыяию".toUpperCase(Locale.ROOT);

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (checkVotes(word)) {
                System.out.println(word);
            }
        }
    }

    private static boolean checkVotes(String word) {
        return VOTES.indexOf(word.charAt(0)) < 0
                && VOTES.indexOf(word.charAt(word.length() - 1)) >= 0;

    }
}
