package by.it.karpovich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    //Отформатировать исходный текст с выравниванием по обоим краям. Для этого
    //добавить дополнительные пробелы между словами, так чтобы ширина строк стала равной, а
    //число пробелов между словами отличалось не более чем на единицу внутри каждой строки,
    //причем на единицу большие последовательности пробелов должны идти с начала строки.
    private static final String LINE_PATTERN = ".[^\\n]+";

    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        int maxLineLength = getLineMaxLength(text);
        Pattern linePattern = Pattern.compile(LINE_PATTERN);
        Matcher lineMatcher = linePattern.matcher(text);
        while (lineMatcher.find()) {
            String line = alignTheLine(lineMatcher.group(), maxLineLength); //выровнять
            System.out.println(line);
        }
    }

    private static String alignTheLine(String line, int targetLength) {
        StringBuilder text = new StringBuilder(line);
        int deficientBlankCount = targetLength - line.length(); // мало пробелов
        int start = 0;
        int iteration = 0;
        for (int i = 0; i < deficientBlankCount; i++) {
            start = text.indexOf(" ", start);
            if (start < 0) {
                iteration++;
                start = text.indexOf(" ", 0);
            }
            text.replace(start, start + 1, "  ");
            start = start + (iteration + 2);
        }
        return text.toString();
    }

    public static int getLineMaxLength(StringBuilder text) {
        int maxLineLength = 0;
        Pattern pattern = Pattern.compile(LINE_PATTERN);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            maxLineLength = Math.max(maxLineLength, matcher.group().length());
        }
        return maxLineLength;
    }
}