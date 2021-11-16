package by.it.karmyzov.jd01_14;

import java.io.*;

public class CopyEx {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("C:\\Users\\Mi Pro\\Desktop\\txt1.txt"));
             BufferedWriter writter = new BufferedWriter(
                     new FileWriter("C:\\Users\\Mi Pro\\Desktop\\txt2.txt"));
        ){
//            int character;
//                    while((character=reader.read())!=-1){
//                        writter.write(character);
//                    }
            String line;
            while ((line=reader.readLine())!=null) {
writter.write(line);
writter.write("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
