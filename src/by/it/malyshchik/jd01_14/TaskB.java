package by.it.malyshchik.jd01_14;

import by.it.malyshchik.jd01_06.Poem;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import static jdk.internal.net.http.common.Utils.close;

//В классе TaskB нужно выполнить следующие шаги:
//В файле с текстом Poem.txt нужно подсчитать общее количество знаков
//препинания и слов
//Вывести результат на консоль в виде одной строки:words=123, punctuation marks=15
//Продублировать вывод в консоль в файл resultTaskB.txt
public class TaskB {

    private static String dir(Class<?> c1) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = c1.getName().replace(c1.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) throws IOException {

//        System.out.println(dir(TaskB.class));
       try( BufferedReader br = new BufferedReader(new FileReader(dir(TaskB.class)+"Poem.txt"));
            PrintWriter out2 = new PrintWriter(new FileWriter(dir(TaskB.class)+"resultTaskB.txt"))){
           String line = br.readLine();
           int words = 0;
           int punctuationMarks = 0;
           while (line!=null) {
               Pattern pattern = Pattern.compile("[a-яA-ЯёЁ]+");
                       Matcher matcher = pattern.matcher(line);
               while (matcher.find()) {
                   words++;
               }
               Pattern pattern1 = Pattern.compile("[!?.,:;-]+");
               Matcher matcher1 = pattern1.matcher(line);
               while (matcher1.find()) {
                   punctuationMarks++;
               } line= br.readLine();

           }
//           while((line=br.readLine()) !=null){
//               Pattern pattern = Pattern.compile("[a-яA-ЯёЁ]+"+"[!?.,:;-]+");
//               Matcher matcher = pattern.matcher(line);
//               while (matcher.find()){
//               words++;
//               punctuationMarks++;
//               line=br.readLine();
//
//       }

     System.out.printf("words=%s, punctuation marks=%s", words, punctuationMarks);
           out2.printf("words=%s, punctuation marks=%s", words, punctuationMarks);

       }
       catch (IOException e) {
           e.printStackTrace();
       }
    }

    }


