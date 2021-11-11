package by.it.antipov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            int b = iterator.next() ;
            if (b<4) {iterator.remove();}
        }
    }

    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>();
        Random random = new Random();
        int numberOfMarks= 12+ random.nextInt(5);
        int [] marks = new int[numberOfMarks];
        for (int i = 0; i < numberOfMarks; i++) {
            list.add(random.nextInt(11));
        }
        TaskA1 newGrades = new TaskA1();
        System.out.println(list);
        newGrades.clearBad(list);
        System.out.println(list);

    }
}
