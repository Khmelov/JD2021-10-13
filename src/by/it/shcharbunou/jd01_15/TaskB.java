package by.it.shcharbunou.jd01_15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskB {

    // commentiruyu svoyu parashu
    public static void main(String[] args) {
        PathFinder pathFinder = new PathFinder();
        String stringPath = pathFinder.getStringPath(TaskB.class, "TaskB.java");
        StringBuilder codeTaskB = readCode(stringPath);
        // ya dodik
        printCodeConsole(codeTaskB);
        outputCodeFile(codeTaskB, pathFinder);
    }

    private static void outputCodeFile(StringBuilder codeTaskB, PathFinder pathFinder) {
        String stringPath = pathFinder.getStringPath(TaskB.class, "TaskB.txt");
        try (PrintWriter printWriter = new PrintWriter(stringPath)) {
            printWriter.println(codeTaskB);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printCodeConsole(StringBuilder codeTaskB) {
        System.out.println(codeTaskB);
    }

    /*
        mama ya programmist
     */

    /**
     *
     * @param stringPath - fuck this method
     * @return - fuck return
     */
    private static StringBuilder readCode(String stringPath) {
        StringBuilder temporaryCodeText = new StringBuilder();
        int intCharacter;
        char character;
        char temporaryCharacter;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(stringPath))) {
            while ((intCharacter = bufferedReader.read()) != -1) {
                character = (char) intCharacter;
                if (character == '/') {
                    if ((intCharacter = bufferedReader.read()) != -1) {
                        temporaryCharacter = (char) intCharacter;
                        if (temporaryCharacter == '/') {
                            while (bufferedReader.read() != '\r' || bufferedReader.read() != '\n') {

                            }
                            temporaryCodeText.append("\r");
                        } else if (temporaryCharacter == '*') {
                            if ((bufferedReader.read()) != -1) {
                                while ((bufferedReader.read()) != '*' || (bufferedReader.read()) != '/') {

                                }
                            } else {
                                break;
                            }
                        } else {
                            temporaryCodeText.append(character).append(temporaryCharacter);
                        }
                    } else {
                        break;
                    }
                } else {
                    temporaryCodeText.append(character);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temporaryCodeText;
    }

    /*
    fuck BSUIR
     */
}
