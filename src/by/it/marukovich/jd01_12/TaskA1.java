package by.it.marukovich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            Integer grade = iterator.next();
            if(grade<4){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        int count = 20+ random.nextInt(21);
        for (int i = 0; i < count; i++) {
            Integer grade=1+ random.nextInt(10);
            list.add(grade);
        }
        System.out.println("List before" + list);
        TaskA1 task = new TaskA1();
        task.clearBad(list);
        System.out.println("List after" + list);

    }
}
