package by.it.shcharbunou.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static void main(String[] args) {
        PathFinder pathFinder = new PathFinder();
        String text = readText(pathFinder);
        int wordsCount = findWordsCount(text);
        int punctuationMarksCount = findPunctuationMarksCount(text);
        printAnswerConsole(wordsCount, punctuationMarksCount);
        printAnswerFile(wordsCount, punctuationMarksCount, pathFinder);
    }

    private static void printAnswerFile(int wordsCount, int punctuationMarksCount, PathFinder pathFinder) {
        String stringPath = pathFinder.getStringPath(TaskB.class, "resultTaskB.txt");
        try (PrintWriter printWriter = new PrintWriter(stringPath)) {
            printWriter.printf("words=%d, punctuation marks=%d", wordsCount, punctuationMarksCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printAnswerConsole(int wordsCount, int punctuationMarksCount) {
        System.out.printf("words=%d, punctuation marks=%d", wordsCount, punctuationMarksCount);
    }

    private static int findPunctuationMarksCount(String text) {
        String regex = "[!?,.:;-]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    private static int findWordsCount(String text) {
        String regex = "[а-яА-ЯёЁ]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int counter = 0;
        while (matcher.find()) {
            counter++;
        }
        return counter;
    }

    private static String readText(PathFinder pathFinder) {
        String stringPath = pathFinder.getStringPath(TaskB.class, "Poem.txt");
        StringBuilder temporaryText = new StringBuilder();
        String temporaryLine;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(stringPath))) {
            while ((temporaryLine = bufferedReader.readLine()) != null) {
                temporaryText.append(temporaryLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temporaryText.toString();
    }
}
