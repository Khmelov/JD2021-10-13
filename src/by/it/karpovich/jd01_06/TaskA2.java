package by.it.karpovich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] element = {};
    private static int[] count = {};

    private static int pos(String word) {
        for (int i = 0; i < TaskA2.element.length; i++) {
            if (TaskA2.element[i].equals(word)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {

            String word = matcher.group();
            int p = pos(word);
            if (p >= 0) {
                count[p]++;
            } else {
                int last = TaskA2.element.length; // Последний элемент
                TaskA2.element = Arrays.copyOf(TaskA2.element, last + 1);
                TaskA2.element[last] = word; // Запомним слово
                count = Arrays.copyOf(count, last + 1);
                count[last] = 1; // Указываем частоту повторений = 1
            }
        }
        for (int i = 0; i < element.length; i++) {
            System.out.println(element[i] + "=" + count[i]);
        }

    }
}
