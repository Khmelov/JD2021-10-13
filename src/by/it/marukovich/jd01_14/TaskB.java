package by.it.marukovich.jd01_14;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TaskB {
    public static void main(String[] args) {
        String text;
        int punctuationCounter = 0;
        int wordsCounter = 0;
        String stringPath = PathFinder.getStringPath(TaskB.class, "Poem.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(stringPath))) {
            while ((text = bufferedReader.readLine()) != null) {
                punctuationCounter += getPunctuation(text);
                wordsCounter += getWords(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Integer> map = new HashMap<>();
        map.put("words", wordsCounter);
        map.put("punctuation symbols", punctuationCounter);
        String textPath = PathFinder.getStringPath(TaskB.class, "resultTaskB.txt");
        try (PrintWriter printWriter = new PrintWriter(textPath)) {
            Set<Map.Entry<String, Integer>> s = map.entrySet();
            Iterator<Map.Entry<String, Integer>> iterator = s.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next());
                if (iterator.hasNext()) {
                    System.out.print(", ");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int getPunctuation(String text) {
        if (text.contains("...")) {
            text = text.replaceAll("\\.{3}", ".");

        }
        int totalSymbols = 0;
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case '.', ',', ':', '!', '?', '-', ';' -> totalSymbols++;
            }
        }
        return totalSymbols;
    }

    private static int getWords(String text) {
        text = text.replaceAll("[^а-яА-ЯёË\s]+", "");
        String[] wordsArray = text.split("\\s+");
        return wordsArray.length;
    }
}

