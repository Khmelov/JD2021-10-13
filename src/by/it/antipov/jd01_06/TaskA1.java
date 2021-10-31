package by.it.antipov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder text1 = new StringBuilder(Poem.text);
        Pattern pattern1 = Pattern.compile("[а-яА-ЯёЁ]{4,6}");
        Pattern pattern2 = Pattern.compile("[а-яА-ЯёЁ]{7,}");
        Matcher match1 = pattern1.matcher(text1);
        Matcher match2 = pattern2.matcher(text1);
        while (match2.find()) {
            int start= match2.start();
            text1.deleteCharAt(start+6);
            text1.insert(start+6,"#");

        }
while (match1.find()) {
    int start= match1.start();
    text1.deleteCharAt(start+3);
    text1.insert(start+3,"#");

}
System.out.println(text1);
    }
}
