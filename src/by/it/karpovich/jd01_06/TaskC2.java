package by.it.karpovich.jd01_06;


import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC2 {
    //Сформировать и вернуть в методе String slow (String text) из случайных слов
    //исходного текста строку String минимум в сто тысяч символов путем конкатенации. Слова
    //должны быть «склеены» через один пробел. Затем:
    //• В методе main: определить время работы метода slow (удобно использовать
    //System.nanoTime() или аналог); вывести полученный текст и время работы метода slow в
    //миллисекундах на консоль.
    //• Ускорить процесс с StringBuilder (сделать новый метод String fast (String text),
    //ВАЖНО: его итог должен быть, таким как в slow до буквы). В main повторить вывод.
    private static final String WORD_PATTERN = "[а-яА-ЯёЁ]+";

    public static void main(String[] args) {
        long startTime;
        long finishTime;
        startTime = System.nanoTime();
        String slowLongText = slow(Poem.text);
        finishTime = System.nanoTime();
        System.out.printf("slowTime: %10g ms \n", (finishTime - startTime) / 1000000.0);
        startTime = System.nanoTime();
        System.out.println(slowLongText);

        String fastLongText = fast(Poem.text);
        finishTime = System.nanoTime();
        System.out.printf("fastTime: %10g ms \n", (finishTime - startTime) / 1000000.0);
        System.out.println(fastLongText);

    }

    private static String slow(String inputText) {
        StringBuilder text = new StringBuilder(inputText);
        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Random random = new Random(23);
        String longtext = "";
        while (longtext.length() < 100000) {
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                if (random.nextBoolean()) {
                    longtext = longtext.concat(matcher.group() + " ");
                }
            }
        }
        return longtext;
    }

    private static String fast(String inputText) {
        StringBuilder text = new StringBuilder(inputText);
        Pattern pattern = Pattern.compile(WORD_PATTERN);
        Random random = new Random(23);
        StringBuilder longtext = new StringBuilder();
        while (longtext.length() < 100000) {
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                if (random.nextBoolean()) {
                    longtext.append(matcher.group());
                    longtext.append(" ");
                }
            }
        }
        return longtext.toString();
    }
}