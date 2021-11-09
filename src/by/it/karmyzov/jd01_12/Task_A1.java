package by.it.karmyzov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task_A1 {

    private List<Integer> list = new ArrayList<>();
    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            int graade = iterator.next();
            if (graade<4)
                iterator.remove();
        }

    }
   // grades.removeIf(i->(i<4));


    public static void main(String[] args) {
        Task_A1 task = new Task_A1();
        for (int i = 0; i <25 ; i++)
            task.list.add((int)Math.ceil(Math.random()*10));
        System.out.println(task.list);
        task.clearBad(task.list);
        System.out.println(task.list);
                }
}
