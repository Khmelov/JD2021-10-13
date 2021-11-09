package by.it.karmyzov.Test.Collections.Map;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx1 {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1000, "Zaur Terer");
        map1.put(2230, "Ivan Ivanov");
        map1.put(1023, "Mariys Sidorova");
        map1.put(1412, "Nikolay Petrov");
//

//        System.out.println(map1);
//        System.out.println(map1.containsValue("Ivan Ivanov"));
//        System.out.println(map1.containsKey(1000));
        System.out.println(map1.keySet());
        System.out.println(map1.values());
        Map<String, String> map2 = new HashMap<>();
        map2.put("Sasha", "KKK");
        System.out.println(map2);
    }
}
