package by.it.karpovich.jd01_14;

// В классе TaskC нужно выполнить следующие шаги:
// Вывести список всех файлов и каталогов вашего пакета by.it.фамилия в
//формате file:имя_файла или dir:имя_каталога.
// Продублировать вывод в консоль в файл resultTaskC.txt

import static by.it.karpovich.jd01_14.Patterns.*;
import java.io.*;
import java.util.*;

public class TaskC {
    public static void main(String[] args) {
        List<String> filePath = new ArrayList<>();
        findFilePath(filePath);
        printAnswerConsole(filePath);
        printAnswerFile(filePath);
    }

    private static void printAnswerFile(List<String> filesAndDirectories) {
        String stringPath = PathFinder.getStringPath(TaskC.class, RESULT_TASK_C_TXT);
        try (PrintWriter printWriter = new PrintWriter(stringPath)) {
            for (String fileString : filesAndDirectories) {
                printWriter.println(fileString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printAnswerConsole(List<String> filesAndDirectories) {
        for (String fileString : filesAndDirectories) {
            System.out.println(fileString);
        }
    }

    private static void findFilePath(List<String> filesAndDirectories) {
        File root = new File("src" + File.separator + "by" + File.separator + "it" + File.separator
                + "karpovich");
        searchRecursive(root, filesAndDirectories);
    }

    private static void searchRecursive(File rootFile, List<String> filesAndDirectories) {
        for (File temporaryFile : Objects.requireNonNull(rootFile.listFiles())) {
            if (temporaryFile.isDirectory()) {
                filesAndDirectories.add("dir:" + temporaryFile.getName());
                searchRecursive(temporaryFile, filesAndDirectories);
            } else {
                filesAndDirectories.add("file:" + temporaryFile.getName());
            }
        }
    }
}