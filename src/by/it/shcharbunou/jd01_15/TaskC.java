package by.it.shcharbunou.jd01_15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class TaskC {

    private static Scanner scanner;

    public static void main(String[] args) {
        String stringRoot = "src" + File.separator + "by" + File.separator + "it" + File.separator
                + "shcharbunou" + File.separator + "jd01_15";
        System.out.println(stringRoot);
        scanner = new Scanner(System.in);
        runApplication(stringRoot);
    }

    private static void runApplication(String stringRoot) {
        String command = inputCommand();
        processCommand(command, stringRoot);
    }

    private static void processCommand(String command, String stringRoot) {
        File root = new File(stringRoot);
        String[] commandAndPath = command.split(" ");
        if (commandAndPath.length == 1 && commandAndPath[0].equals("dir")) {
            Path start = root.toPath();
            int maxDepth = Integer.MAX_VALUE;
            try (Stream<Path> pathStream = Files.walk(start, maxDepth)) {
                pathStream.forEach(System.out::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
            runApplication(stringRoot);
        } else if (commandAndPath.length == 2 && commandAndPath[0].equals("cd")) {
            if (commandAndPath[1].equals("..")) {
                stringRoot = processStringRoot(stringRoot);
                System.out.println(stringRoot);
                runApplication(stringRoot);
            } else {
                File file = new File(stringRoot + File.separator + commandAndPath[1]);
                if (file.exists()) {
                    stringRoot += File.separator + commandAndPath[1];
                    System.out.println(stringRoot);
                    runApplication(stringRoot);
                }
            }
        } else if (commandAndPath.length == 1 && commandAndPath[0].equals("end")) {
            return;
        } else {
            System.out.println("Error");
            runApplication(stringRoot);
        }
    }

    private static String processStringRoot(String stringRoot) {
        int counter = 0;
        for (int i = stringRoot.length() - 1; stringRoot.charAt(i) != '\\'; i--) {
            counter++;
        }
        counter++;
        return stringRoot.substring(0, stringRoot.length() - counter);
    }

    private static String inputCommand() {
        String temporaryString;
        boolean isCorrect;
        do {
            isCorrect = true;
            temporaryString = scanner.nextLine();
            if (temporaryString.equals("")) {
                isCorrect = false;
            }
        } while (!isCorrect);
        return temporaryString;
    }

}
