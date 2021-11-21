package by.it.shcharbunou.jd01_14;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskC {

    public static void main(String[] args) {
        List<String> filesAndDirectories = new ArrayList<>();
        findFilesAndDirectories(filesAndDirectories);
        printAnswerConsole(filesAndDirectories);
        printAnswerFile(filesAndDirectories);
    }

    private static void printAnswerFile(List<String> filesAndDirectories) {
        PathFinder pathFinder = new PathFinder();
        String stringPath = pathFinder.getStringPath(TaskC.class, "resultTaskC.txt");
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

    private static void findFilesAndDirectories(List<String> filesAndDirectories) {
        File root = new File("src" + File.separator + "by" + File.separator + "it" + File.separator
        + "shcharbunou");
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
