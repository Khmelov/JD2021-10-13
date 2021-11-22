package by.it._classwork_.jd01_15;

import by.it._classwork_.jd01_14.PathFinder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * sdfsfsd
 * <p>
 * dsfsdf
 */
public class TaskB {
    /*hjdsgfjhdgfshjdf
    jhsfgjhsjdfgsjdh
     */

    public static void main(String[] args) {
        String filename = PathFinder.getStringPath(TaskB.class, "TaskB.java");
        String txt = null;
        try {
            txt = Files.readString(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert txt != null;
        char[] chars = txt.toCharArray();
        StringBuilder out = new StringBuilder();
        State state = State.CODE;
        for (char ch : chars) {
            switch (state) {
                case CODE:
                    if (ch == '/') {
                        state = State.MAY_BE_COMMENT;
                    } else {
                        out.append(ch);
                    }
                    break;
                case MAY_BE_COMMENT:
                    if (ch == '*') {
                        state = State.MULTILINE;
                    } else if (ch == '/') {
                        state = State.ONE_LINE;
                    } else {
                        state = State.CODE;
                        out.append('/').append(ch);
                    }
                    break;
                case MULTILINE: {
                    if (ch == '*') {
                        state = State.MAY_BE_END_MULTILINE;
                    }
                    break;
                }
                case MAY_BE_END_MULTILINE: {
                    if (ch == '/') {
                        state = State.CODE;
                    } else {
                        state = State.MULTILINE;
                    }
                    break;
                }
                case ONE_LINE: {
                    if (ch == '\n') {
                        state = State.CODE;
                        out.append(ch);
                    }
                    break;
                }
            }
        }

        System.out.println(out);
        String outTxt = PathFinder.getStringPath(TaskB.class, "TaskB.txt");
        try (PrintWriter printWriter = new PrintWriter(outTxt)) {
            printWriter.print(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //test
    }

    //test
}

enum State {
    CODE, MAY_BE_COMMENT, ONE_LINE, MULTILINE, MAY_BE_END_MULTILINE
}
