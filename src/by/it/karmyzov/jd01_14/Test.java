package by.it.karmyzov.jd01_14;

import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        String rubai = "Много лет рамышлял я над жизню земной.\n" +
                       "Непонятного нет для меня под рукой.\n" +
                       "Мне известно, что мне ничего не известно!\n" +
                       "Вот последняя правда, открытая мной.\n";
        String s = "Privet";

        try (
                FileWriter writer = new FileWriter("C:\\Users\\Mi Pro\\Desktop\\txt1.txt", true)) {
            for (int i = 0; i < rubai.length(); i++) {
                writer.write(rubai.charAt(i));
            }
            writer.write(s);
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}




