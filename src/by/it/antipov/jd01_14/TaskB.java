package by.it.antipov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {
        StringBuilder path = new StringBuilder(System.getProperty("user.dir"));
        String path2=TaskB.class.getName().replace(".", File.separator).replace("TaskB","");
        path = path.append(File.separator+"src"+File.separator+path2+File.separator+"Poem.txt");
        StringBuilder path3 = new StringBuilder(System.getProperty("user.dir"));
        path3.append(File.separator + "src" + File.separator + path2 + File.separator + "resultTaskB.txt");
       // System.out.println(path);
        StringBuilder Text = new StringBuilder();
        File poem = new File(String.valueOf(path));
        try (BufferedReader reader = new BufferedReader(new FileReader(poem))){
           String expression=reader.readLine();
           while (expression!=null){
               Text.append(expression);
               Text.append("\n");
           expression=reader.readLine();}
        } catch (FileNotFoundException e) {
            System.out.println("file not found"+e);
        } catch (IOException e) {
            System.out.println("smth wrong with file");
        }
        Pattern pattern1 = Pattern.compile("[а-яА-яё]+");
        Matcher matcher1 = pattern1.matcher(Text);
        Pattern pattern2 = Pattern.compile("[:!,.-]+");
        Matcher matcher2 = pattern2.matcher(Text);
        int counterWords=0;
        int counterPuncts=0;
        while (matcher1.find()){counterWords++;}
        while (matcher2.find()){counterPuncts++;}
        String wordsNumber = "words="+counterWords;
        System.out.println(wordsNumber);
        String punctsNumber= "punctuation marks="+counterPuncts;
        System.out.println(punctsNumber);
File information = new File(String.valueOf(path3));
try (BufferedWriter info = new BufferedWriter(new FileWriter(information))) {
    info.write(wordsNumber+"\n");
    info.write(punctsNumber);
} catch (FileNotFoundException e) {
    System.out.println("file not found"+e);
} catch (IOException e) {
    System.out.println("smth wrong with file");
}
    }
}
