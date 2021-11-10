package by.it.malyshchik.jd01_12;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {
//   Создайте в классе TaskA1 приватное поле - список оценок учеников (с помощью ArrayList).
//             Заполните его из метода main случайными оценками (1-10).
//             Удалите неудовлетворительные оценки (1-3) из списка с помощью
//    нестатического метода void clearBad(List<Integer> grades) с итератором.
//             Выведите на консоль оба варианта списка (до и после удаления).

    @SuppressWarnings("Java8CollectionRemoveIf")

    void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while(iterator.hasNext()){
            Integer grade = iterator.next();
            if(grade<4){
                iterator.remove();
            }
        }
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        int count = 10 + random.nextInt(21);
        for (int i = 0; i < count; i++) {
            Integer grade = 1 + random.nextInt(10);
            list.add(grade);
        }
        System.out.println("First: "+ list);
        TaskA1 task = new TaskA1();
        task.clearBad(list);
        System.out.println("Second: "+ list);


    }



}
