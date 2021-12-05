package by.it.karpovich.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static by.it.karpovich.jd01_14.Patterns.*;

public class TaskB {

    public static void main(String[] args) {
        String stringPath = PathFinder.getStringPath(TaskB.class, POEM_TXT);
        String text = readText(stringPath);
        int words = getCount(text, WORD_RUS);
        text = text.replace(ELLIPSIS, DOT);
        int punctuation = getCount(text, SYMBOL_TEXT);
        System.out.printf(WORDS_PUNCTUATION, words, punctuation);
        String resultTaskB = PathFinder.getStringPath(TaskB.class, RESULT_TASK_B_TXT);
        writeResult(words, punctuation, resultTaskB);
    }

    private static void writeResult(int words, int punctuation, String resultTaskB) {
        try (PrintWriter printWriter = new PrintWriter(resultTaskB)) {
            printWriter.printf(WORDS_PUNCTUATION, words, punctuation);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String readText(String stringPath) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(stringPath))) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stringBuilder.toString();
    }

    private static int getCount(String text, String pattern) {
        int count = 0;
        Matcher wordMatcher = Pattern.compile(pattern).matcher(text);
        while (wordMatcher.find()) {
            count++;
        }
        return count;
    }
}