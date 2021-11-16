package by.it.rudakova.jd01_14;


import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TaskB {
    public static void main(String[] args) {
        String line;
        int punctuationCounter = 0;
        int wordsCounter = 0;
        String filePath = getStringPath(TaskB.class, "Poem.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while ((line = bufferedReader.readLine()) != null) {
                punctuationCounter = punctuationCounter + getPunctuation(line);
                wordsCounter = wordsCounter + getWords(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e);
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("words", wordsCounter);
        map.put("punctuation marks", punctuationCounter);

        String textPath = getStringPath(TaskB.class, "resultTaskB.txt");
        try (PrintWriter printWriter = new PrintWriter(textPath)) {
            Set s = map.entrySet();
            Iterator it = s.iterator();
            while (it.hasNext()) {
                System.out.print(it.next());
                if (it.hasNext()) {
                    System.out.print(", ");
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getStringPath(Class<?> bClass, String fileName) {
        String root = System.getProperty("user.dir");
        System.out.println(root);
        bClass = TaskB.class;
        String className = bClass.getName();
        String packageName = className.replace(bClass.getSimpleName(), "");
        String packagePath = packageName.replace(".", File.separator);
        String result = root + File.separator + "src" + File.separator + packagePath + fileName;
        System.out.println(result);
        return result;
    }

    private static int getPunctuation(String line) {
        if (line.contains("...")) {
            line = line.replaceAll("\\.{3}", ".");

        }
        int total = 0;
        for (int i = 0; i < line.length(); i++) {
            switch (line.charAt(i)) {
                case '.':
                case ',':
                case ':':
                case '!':
                case '?':
                case '-':
                case ';':
                    total++;
                    break;
            }
        }
        return total;
    }

    private static int getWords(String line) {
        line = line.replaceAll("[^а-яА-ЯёË\s]+", "");
        String[] wordsArray = line.split("\\s+");
        return wordsArray.length;
    }
}
