package by.it.karpovich.jd01_15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class TaskB {
    static final String CLASS_FILE_NAME = "TaskB.java";
    static final String TXT_FILE_NAME = "TaskB.txt";

    //comment 1

    public static void main(String[] args) {

        StringBuilder classContents = classToStringBuilder(TaskB.class);
        deleteCommentaries(classContents);
        System.out.println(classContents);
        String txtFilePath = PathCreator.getFileName(TaskB.class, TXT_FILE_NAME);
        printToFile(txtFilePath, classContents);

        /*multiline comment 1
        multiline comment 1
        multiline comment 1*/
    }

    private static void printToFile(String filePath, StringBuilder stringBuilder) {
        try (PrintWriter printWriter = new PrintWriter(filePath)) {
            printWriter.println(stringBuilder.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteCommentaries(StringBuilder classContents) {
        Condition condition = Condition.OUTSIDE_COMMENT;
        for (int i = 0; i < classContents.length(); i++) {
            char ch = classContents.charAt(i);
            switch (condition) {
                case OUTSIDE_COMMENT:
                    if (ch == '/') {
                        condition = Condition.FIRST_SLASH;

                    }
                    break;
                case FIRST_SLASH:
                    if (ch == '/') {
                        condition = Condition.LINE_COMMENT;
                        classContents.deleteCharAt(i--);
                        classContents.deleteCharAt(i--);
                    } else if (ch == '*') {
                        condition = Condition.STAR;
                        classContents.deleteCharAt(i--);// comment2
                        classContents.deleteCharAt(i--);
                    } else {
                        condition = Condition.OUTSIDE_COMMENT;
                    }
                    break;
                case LINE_COMMENT:
                    if (ch != '\n') {
                        classContents.deleteCharAt(i--);
                    } else {
                        condition = Condition.OUTSIDE_COMMENT;
                    }
                    break;
                case STAR:
                    classContents.deleteCharAt(i--);
                    if (ch == '/') {
                        condition = Condition.OUTSIDE_COMMENT;
                    }
            }
        }
    }

    /**
     * @param aClass input class structure
     * @return StringBuilder with class code
     */

    private static StringBuilder classToStringBuilder(Class<?> aClass) {
        String classPath = PathCreator.getFileName(aClass, CLASS_FILE_NAME);
        try {
            return new StringBuilder(
                    Files.lines(Paths.get(classPath)).collect(Collectors.joining("\n"))
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

enum Condition {
    OUTSIDE_COMMENT,
    FIRST_SLASH,
    LINE_COMMENT,
    STAR,
}
        /*multiline comment 2
        multiline comment 2
        multiline comment 2*/