package by.it.rudakova.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StringBuilder stringBuilder=new StringBuilder();
        String englishText;
        while (true) {
            englishText=scanner.nextLine();
            if(englishText.equals("end")){
                break;
            }
            stringBuilder.append(englishText);
        }
        englishText=stringBuilder.toString();
        englishText=englishText.replaceAll("[^a-zA-Z'\s]+","");
        String [] englishWordsArray=englishText.split("\\s+");
        List<String> wordsList= Arrays.asList(englishWordsArray);
        Map<String,Integer> wordsMap=new HashMap<>();

        for(String element:wordsList) {
                if (!wordsMap.containsKey(element)) {
                    wordsMap.put(element, 1);
                } else {
                    wordsMap.put(element, wordsMap.get(element) + 1);
                }
        }

        for(String element:wordsMap.keySet()){
            System.out.println(element+"="+wordsMap.get(element));
        }
    }
}
