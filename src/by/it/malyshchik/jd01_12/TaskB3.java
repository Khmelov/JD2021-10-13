package by.it.malyshchik.jd01_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

//Скопируйте предыдущую задачу и измерьте на размере задачи в 4096
//  элемент какой из двух методов работает быстрее. Объясните итог.
//  Подумайте, как можно было бы решить задачу в методе
//   prоcess(LinkedList<String> peoples) без итератора и снижения
//   быстродействия, используя интерфейсы очередей. Проверьте свою идею.
public class TaskB3 {

    public static void main(String[] args) {
            String[] arr = new String[4096];

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(arr));
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList(arr));
        long startAL = System.currentTimeMillis();
        System.out.println("AL " + process(arrayList));
        long endAL = System.currentTimeMillis();
        System.out.println("Running time for ArrayList -  "+(endAL-startAL)+" nanoseconds");
        long startLL = System.currentTimeMillis();
        System.out.println("LL " + process(linkedList));
        long endLL = System.currentTimeMillis();
        System.out.println("Running time for LinkedList - "+(endLL-startLL)+" nanoseconds");

    }

    static String process(ArrayList<String> peoples) {
        boolean a = false;
        while (peoples.size()>1){
            Iterator<String> iterator = peoples.iterator();
            while(iterator.hasNext()){
                iterator.next();

                if (a) {
                    iterator.remove();
                }
                a=!a;
            }

        }

        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples){
        while (peoples.size()>1){
            String s = peoples.removeFirst();
            peoples.addLast(s);
            peoples.removeFirst();
        }
        return peoples.get(0);
    }

}
