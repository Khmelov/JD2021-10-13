package by.it.shcharbunou.jd01_12;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    public static void main(String[] args) {
        // String text = inputText();
        String text = Test_jd01_12.text;
        text = text.replaceAll("[^a-zA-Z']+end(?![a-zA-Z])", "");
        text = text.replaceAll("[^a-zA-Z']+", "\n");
        String[] objects = text.split("\n");
        Map<Integer, String> objectsMap = new TreeMap<>();
        fillMap(objectsMap, objects);
        printMap(objectsMap);
        objectsMap.clear();
        fillUniqueMap(objectsMap, objects);
        printMap(objectsMap);
    }

    private static void fillUniqueMap(Map<Integer, String> map, String[] objects) {
        for (String object : objects) {
            if (!object.equals("")) {
                map.put(object.hashCode(), object);
            }
        }
    }

    private static void printMap(Map<Integer, String> map) {
        System.out.println(map.toString());
    }

    private static void fillMap(Map<Integer, String> map, String[] objects) {
        int hashCode;
        for (String object : objects) {
            if (!object.equals("")) {
                hashCode = object.hashCode();
                while (map.containsKey(hashCode)) {
                    hashCode++;
                }
                map.put(hashCode, object);
            }
        }
    }

    private static String inputText() {
        Scanner scanner = new Scanner(System.in);
        String temporaryText;
        boolean isChecked;
        String[] textBeforeEnd = null;
        do {
            isChecked = true;
            temporaryText = scanner.nextLine();
            if (checkEnd(temporaryText)) {
                textBeforeEnd = temporaryText.split("[^a-zA-Z']+end(?![a-zA-Z])");
            } else {
                isChecked = false;
            }
        } while (!isChecked);
        return textBeforeEnd[0];
    }

    private static boolean checkEnd(String temporaryText) {
        String endRegex = "[^a-zA-Z']+end(?![a-zA-Z])";
        Pattern pattern = Pattern.compile(endRegex);
        Matcher matcher = pattern.matcher(temporaryText);
        return matcher.find();
    }
}
