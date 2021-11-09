package by.it.shcharbunou.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private final List<Integer> marksList = new ArrayList<>();

    public static void main(String[] args) {
        Random random = new Random();
        TaskA1 taskA1 = new TaskA1();
        fillMarksList(random, taskA1.marksList);
        printMarksList(taskA1.marksList);
        taskA1.clearBad(taskA1.marksList);
        printMarksList(taskA1.marksList);
    }

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> gradesIterator = grades.iterator();
        while (gradesIterator.hasNext()) {
            Integer mark = gradesIterator.next();
            if (mark < 4) {
                gradesIterator.remove();
            }
        }
    }

    private static void printMarksList(List<Integer> marksList) {
        System.out.println(marksList);
    }

    private static void fillMarksList(Random random, List<Integer> marksList) {
        final int MAX_COUNT = 30;
        final int MIN_COUNT = 10;
        final int MAX_MARK = 10;
        final int MIN_MARK = 1;
        int marksCount = random.nextInt(MAX_COUNT - MIN_COUNT + 1) + MIN_COUNT;
        for (int i = 0; i < marksCount; i++) {
            marksList.add(random.nextInt(MAX_MARK - MIN_MARK + 1) + MIN_MARK);
        }
    }
}
