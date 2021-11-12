//
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Random;
//
//public class TaskA1 {
//    void clearBad(List<Integer> grades) {
//        Iterator<Integer> iterator = grades.iterator();
//        while (iterator.hasNext()) {
//            Integer grade = iterator.next();
//            if (grade < 4) {
//                iterator.remove();
//            }
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        Random random = new Random();
//        int counter = 20 + random.nextInt(21);
//        for (int i = 0; i < counter; i++) {
//            Integer grade = 1 + random.nextInt(10);
//            list.add(grade);
//        }
//        System.out.println("List before: " + list);
//
//
//        System.out.println("List after: " + list);
//        TaskA1 taskA1 = new TaskA1();
//        taskA1.clearBad(list);
//        System.out.println(list);
//    }
//}
// 36  src/by/it/rudakova/jd01_12/TaskA2.java
//@@ -0,0 +1,36 @@
//        package by.it.rudakova.jd01_12;
//
//        import java.util.Arrays;
//        import java.util.HashSet;
//        import java.util.List;
//        import java.util.Set;
//
//public class TaskA2 {
//    public static void main(String[] args) {
//        Integer[] firstArray = {1, 1, 2, 2, 3, 4, 5, 5, 6, 6, 7};
//        Integer[] secondArray = {9, 9, 8, 8, 7, 7, 6, 5, 5, 4};
//        List<Integer> array1 = Arrays.asList(firstArray);
//        List<Integer> array2 = Arrays.asList(secondArray);
//        HashSet<Integer> hashSet = new HashSet<>(array1);
//        HashSet<Integer> treeSet = new HashSet<>(array2);
//        System.out.println("hashSet: " + hashSet);
//        System.out.println("treeSet: " + treeSet);
//        Set<Integer> union = getUnion(hashSet, treeSet);
//        System.out.println("union: " + union);
//        Set<Integer> cross = getCross(hashSet, treeSet);
//        System.out.println("cross: " + cross);
//
//    }
//
//    private static Set<Integer> getUnion(Set<Integer> left, Set<Integer> right) {
//        HashSet<Integer> result = new HashSet<>(left);
//        result.addAll(right);
//        return result;
//    }
//
//    private static Set<Integer> getCross(Set<Integer> left, Set<Integer> right) {
//        HashSet<Integer> result = new HashSet<>(left);
//        result.retainAll(right);
//        return result;
//    }
//}
// 29  src/by/it/rudakova/jd01_12/TaskA3.java
//@@ -0,0 +1,29 @@
//        package by.it.rudakova.jd01_12;
//
//        import java.util.ArrayList;
//        import java.util.List;
//        import java.util.Scanner;
//
//public class TaskA3 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        List<Integer> values = new ArrayList<>();
//        int posZero = 0;
//        for (; ; ) {
//            String value = scanner.next();
//            if (!value.equals("end")) {
//                Integer i = Integer.valueOf(value);
//                if (i < 0) {
//                    values.add(i);
//                } else if (i > 0) {
//                    values.add(posZero++, i);
//                } else {
//                    values.add(posZero, i);
//                }
//            } else {
//                break;
//            }
//        }
//        System.out.println("values: " + values);
//    }
//}
// 35  src/by/it/rudakova/jd01_12/TaskB1.java
//@@ -0,0 +1,35 @@
//        package by.it.rudakova.jd01_12;
//
//        import java.util.*;
//
//public class TaskB1 {
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        StringBuilder stringBuilder=new StringBuilder();
//        String englishText;
//        while (true) {
//            englishText=scanner.nextLine();
//            if(englishText.equals("end")){
//                break;
//            }
//            stringBuilder.append(englishText);
//        }
//        englishText=stringBuilder.toString();
//        englishText=englishText.replaceAll("[^a-zA-Z'\s]+","");
//        String [] englishWordsArray=englishText.split("\\s+");
//        List<String> wordsList= Arrays.asList(englishWordsArray);
//        Map<String,Integer> wordsMap=new HashMap<>();
//
//        for(String element:wordsList) {
//            if (!wordsMap.containsKey(element)) {
//                wordsMap.put(element, 1);
//            } else {
//                wordsMap.put(element, wordsMap.get(element) + 1);
//            }
//        }
//
//        for(String element:wordsMap.keySet()){
//            System.out.println(element+"="+wordsMap.get(element));
//        }
//    }
//}
// 71  src/by/it/rudakova/jd01_12/TaskB2.java
//@@ -0,0 +1,71 @@
//        package by.it.rudakova.jd01_12;
//
//        import java.util.ArrayList;
//        import java.util.Iterator;
//        import java.util.LinkedList;
//
//public class TaskB2 {
//    public static void main(String[] args) {
//
//        ArrayList<String> peopleArrayList=new ArrayList<>();
//        peopleArrayList.add("Таня");
//        peopleArrayList.add("Маша");
//        peopleArrayList.add("Саша");
//        peopleArrayList.add("Коля");
//        peopleArrayList.add("Сережа");
//        peopleArrayList.add("Вася");
//        peopleArrayList.add("Наташа");
//
//        LinkedList<String> peopleLinkedList=new LinkedList<>();
//        peopleLinkedList.add("Таня");
//        peopleLinkedList.add("Маша");
//        peopleLinkedList.add("Саша");
//        peopleLinkedList.add("Коля");
//        peopleLinkedList.add("Сережа");
//        peopleLinkedList.add("Наташа");
//        peopleLinkedList.add("Вася");
//        peopleLinkedList.add("Петя");
//
//        String firstName=process(peopleArrayList);
//        System.out.println(firstName);
//
//        String secondName=process(peopleLinkedList);
//        System.out.println(secondName);
//
//
//
//
//    }
//
//    static String process(ArrayList<String> peoples) {
//        int i=0;
//        while (peoples.size()!=1) {
//            Iterator iterator = peoples.iterator();
//            while (iterator.hasNext()) {
//                iterator.next();
//                if (i % 2 != 0) {
//                    iterator.remove();
//                }
//                i++;
//            }
//        }
//
//        return peoples.get(0);
//    }
//
//    static String process(LinkedList<String> peoples){
//        int i=0;
//        while (peoples.size()!=1) {
//            Iterator iterator=peoples.iterator();
//            while (iterator.hasNext()) {
//                iterator.next();
//                if (i % 2 != 0) {
//                    iterator.remove();
//                }
//                i++;
//            }
//        }
//
//        return peoples.get(0);
//    }
//}
// 72  src/by/it/rudakova/jd01_12/TaskB3.java
//@@ -0,0 +1,72 @@
//        package by.it.rudakova.jd01_12;
//
//        import org.junit.rules.Stopwatch;
//
//        import java.util.ArrayList;
//        import java.util.Iterator;
//        import java.util.LinkedList;
//        import java.util.List;
//
//public class TaskB3 {
//    public static void main(String[] args) {
//        int number=4096;
//
//        ArrayList<String> peopleArrayList = new ArrayList<>();
//        fillCollection(peopleArrayList, number);
//
//        LinkedList<String> peopleLinkedList = new LinkedList<>();
//        fillCollection(peopleLinkedList,number);
//
//        long finish=0;
//        long start=System.currentTimeMillis();
//
//        String firstName = process(peopleArrayList);
//        System.out.println(firstName);
//        finish=System.currentTimeMillis();
//        System.out.println("Работа ArrayList: "+(finish-start));
//
//        start=System.currentTimeMillis();
//        String secondName = process(peopleLinkedList);
//        System.out.println(secondName);
//        finish=System.currentTimeMillis();
//        System.out.println("Работа LinkedList: "+(finish-start));
//    }
//
//    static String process(ArrayList<String> peoples) {
//        int i = 0;
//        while (peoples.size() != 1) {
//            Iterator iterator = peoples.iterator();
//            while (iterator.hasNext()) {
//                iterator.next();
//                if (i % 2 != 0) {
//                    iterator.remove();
//                }
//                i++;
//            }
//        }
//
//        return peoples.get(0);
//    }
//
//    static String process(LinkedList<String> peoples) {
//        int i = 0;
//        while (peoples.size() != 1) {
//            Iterator iterator = peoples.iterator();
//            while (iterator.hasNext()) {
//                iterator.next();
//                if (i % 2 != 0) {
//                    iterator.remove();
//                }
//                i++;
//            }
//        }
//
//        return peoples.get(0);
//    }
//
//    private static void fillCollection(List<String> myList, int number) {
//        for (int i = 0; i < number; i++) {
//            myList.add("name" + i);
//        }
//    }
//}