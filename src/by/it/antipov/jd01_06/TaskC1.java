package by.it.antipov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        int max = 0;

        Pattern pattern1 = Pattern.compile("[^\n]+");
        Pattern pattern2 = Pattern.compile("[ ]+");
        Matcher match1 = pattern1.matcher(Poem.text);
        String[] array = Poem.text.split("[\n]");


        while (match1.find()) {
            if (match1.group().length() > max) {
                max = match1.group().length();
            }
        }
        for (int i = 0; i < array.length; i++) {
            while (array[i].length() != max) {int add=0; Matcher match2 = pattern2.matcher(array[i]);
                while (match2.find()) {
                    if (array[i].length() < max) {
                       // System.out.println("index="+match2.end()+"group="+match2.group()+"]");
                        array[i] = (new StringBuilder(array[i]).insert(match2.end()+add,' ')).toString();
                        add++;

                    }
                }

            }
            System.out.println(array[i]);
        }

    }

}

