package by.it.rudakova.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        String text=Poem.text;
        String [] lineArray=text.split("\n");
        lineArray=getSentences(lineArray);

        for(int i=0;i<lineArray.length;i++){
            lineArray[i]=changeNonLetterSymbols(lineArray[i]);
        }

        System.out.println();

        String [] newArray=trimArray(lineArray);
        trimAll(newArray);
        sortArrayBubble(newArray);
        printArray(newArray);
    }

    private static String changeNonLetterSymbols(String chars){
        StringBuilder stringBuilder=new StringBuilder(chars);
        for(int i=0;i<stringBuilder.length();i++){
            boolean nonLetterSymbol=findNonLetterSymbol(stringBuilder.charAt(i));
            if(nonLetterSymbol==true){
                stringBuilder.setCharAt(i, ' ');
                i--;
            }
        }

        return stringBuilder.toString();
    }

    private static boolean findNonLetterSymbol(char c){
        switch (c){
            case ',':
            case '.':
            case '-':
            case ':':
            case '?':
            case '!':
                return true;
        }
        return false;
    }

    private static void trimAll(String[] array)
    {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i< array.length; i++) {
            boolean isGotSpace = false;
            for (int k = 0; k<array[i].length(); k++) {
                if (array[i].charAt(k) == ' '){
                    if (isGotSpace){
                        continue;
                    }
                    isGotSpace = true;
                }
                else {
                    isGotSpace = false;
                }
                builder.append(array[i].charAt(k));
            }

            array[i] = builder.toString();
            builder = new StringBuilder();
        }
    }

    private static String[] trimArray(String [] array){
        String [] newLines=new String[array.length];
        for (int i=0;i<array.length;i++){
            String st=array[i].trim();
            newLines[i]=st;
        }
        return newLines;
    }

    private static void printArray(String [] array){
        for(String element:array){
            System.out.println(element);
        }
    }

    private static void sortArrayBubble(String [] array){
        for(int i=1;i<array.length;i++){
            for(int k=0;k<array.length-i;k++){
                if(array[k].length()>array[k+1].length()){
                    String buffer=array[k];
                    array[k]=array[k+1];
                    array[k+1]=buffer;
                }
            }
        }
    }

    private static String[] getSentences(String[] array){
        StringBuilder stringBuilder=new StringBuilder();
        String [] newArray=new String[array.length];
        int k=0;
        for(int i=0;i< array.length;i++){
            stringBuilder.append(array[i]);
            stringBuilder.append(' ');
            if(array[i].charAt(array[i].length()-1)=='.'||array[i].charAt(array[i].length()-1)=='!'){
                newArray[k]=stringBuilder.toString();
                stringBuilder=new StringBuilder();
                k++;
            }

        }

        String [] result=new String[k];
        for(int i=0;i<result.length;i++){
            result[i]=newArray[i];
        }

        return result;
    }
}
