/**
 * java doc
 */
package by.it.antipov.jd01_15;

import java.io.*;

public class TaskB {//dfgdfgdfg
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        path = path + File.separator + "src" + File.separator + TaskB.class.getName().replace(".", File.separator) + ".java";
        String path2 = System.getProperty("user.dir") + File.separator + "src" + File.separator + TaskB.class.getName().replace(".", File.separator) + ".txt";
        System.out.println(path);
        File file = new File(path);
        File file1 = new File(path2);
        StringBuilder text = new StringBuilder("");
        try (FileReader reader = new FileReader(file)) { //sgdfgdfg
            first:
            for (; ; ) {
                char symbol = (char) reader.read();
                if ('\uFFFF' == symbol) {
                    break;
                }
                if (symbol == '/') {
                    for (int i = 0; i < 1; i++) {
                        char symbol2 = (char) reader.read();
                        if (symbol2 == '*') {
                            if ('*' == (char) reader.read()) {
                                for (; ; ) {
                                    char symbol6 = (char) reader.read();
                                    if (symbol6 == '*') {
                                        if ('/' == (char) reader.read()) {
                                            continue first;
                                        }
                                    }
                                }
                            } else {
                                for (; ; ) {
                                    char symbol4 = (char) reader.read();
                                    if (symbol4 == '*') {
                                        if ('/' == (char) reader.read()) {
                                            continue first;
                                        }
                                    }
                                }
                            }
                        } else if (symbol2 == '/') {for (; ; ) {/* sadasdasd
        asda
        */
                                    char symboln = (char) reader.read();
                                    if (symboln == '\n') {continue first;}}}
                        else {text.append('/');
                            System.out.print('/');
                            text.append(symbol2);
                            System.out.print(symbol2);}
                    }
                } else {
                    text.append(symbol);
                    System.out.print(symbol);
                }
            }
        } catch (FileNotFoundException e) { /* sadasdasd
        asda
        */
            System.out.println("error 1");
        } catch (IOException e) {
            System.out.println("error 2");
        }
        try (FileWriter writer = new FileWriter(file1)) {
            writer.write(String.valueOf(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
