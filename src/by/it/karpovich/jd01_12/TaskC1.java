package by.it.karpovich.jd01_12;

// TaskC1. Нужно ввести с консоли текст до строки end. Во входном тексте хранятся
//наименования некоторых объектов, по одному в строке.
//Строки иногда повторяются.
// Построить ассоциативный массив C, элементы которого содержат наименования
//(значения) и уникальные шифры (ключи) данных объектов, причем элементы
//списка должны быть упорядочены по возрастанию шифров (шифр – некоторое
//случайное, но гарантированно уникальное число).
// Выведите полученный ассоциативный массив в консоль методом toString()
// Затем нужно «сжать» список C, удаляя дублирующийся наименования объектов
//(оставляйте первое вхождение наименования, остальные – удаляются).
// Выведите полученный ассоциативный массив в консоль методом toString()

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class TaskC1 {


    public static void main(String[] args) {

        // init map
        stringMap = new HashMap<>();
        shrinkMap = new HashMap<>();

        //init scanner
        scan();

        System.out.println(stringMap.toString());
        shrink();
        System.out.println(shrinkMap.toString());

    }

    static Map<Integer, String> stringMap;
    static Map<Integer, String> shrinkMap;

    public static void scan() {
        Random rn = new Random();

        Scanner scanner = new Scanner(System.in);
        String scan =scanner.nextLine();
        while (!scan.equals("end")) {
            int temp = rn.nextInt();
            while(stringMap.containsKey(temp)) {
                temp = rn.nextInt(); // Поиск уникального числа
            }
            stringMap.put(temp,scan);
            scan = scanner.nextLine();
        }
    }

    public static void shrink() {
        stringMap.forEach((k, v) -> {

            if (!shrinkMap.containsValue(v)) {
                shrinkMap.put(k,v);
            }

        });
    }


    //-> s
    //map.add(s.hash,s)
    //System.out.pr map.tosString

    //foreach

    //if


}
