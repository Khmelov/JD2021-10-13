package by.it.antipov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
int max=0;

        Pattern pattern1 = Pattern.compile("[^\n]+");
        Pattern pattern2 = Pattern.compile("[ ]+");
        Matcher match1 = pattern1.matcher(Poem.text);
        String[]array = Poem.text.split("[\n]");


        while (match1.find()) {if (match1.group().length()>max)
        {max = match1.group().length();}
        }
        for (int i = 0; i < array.length; i++) {
            Matcher match2 =pattern2.matcher(array[i]);
            while (array[i].length()!=max){while(match2.find()){if(array[i].length()<max){array[i]=(new StringBuilder(array[i]).insert(match2.end(),' ')).toString();}}}
            System.out.println(array[i]);
            }

        }

    }

