package by.it.malyshchik.jd01_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;



//Нужно ввести с консоли текст на английском языке до строки “end” (100 и  более слов).
//  Для каждого слова с помощью коллекций подсчитать частоту его встречаемости.
//  Вывести все различные слова формате слово=частота. Слова, отличающиеся
//        регистром букв, считать различными. isn't или don’t – одно слово.
public class TaskB1 {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String words = sc.nextLine();
            if (words.equals("end")) {

                break;
            }


            for (String word : words.split("[,.:; ]"))
                map.put(word, map.getOrDefault(word, 0) + 1);
//        }
            System.out.println(map);
        }

    }
}

