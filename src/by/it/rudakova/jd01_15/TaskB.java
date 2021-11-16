package by.it.rudakova.jd01_15;

import java.io.*;

public class TaskB {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        String filePath = getStringPath(TaskB.class, "TaskB.java");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) { // всегда заворачиваем FileReader в BufferedReader
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
/*
removeSingleLineComment(line);
Пересохраняем содержимое StringBuilber в String.
Затем спритим содержимое String и пересохраняем в массив строк.
Далее массив строк сохраняем в коллекцию.
 */
        String stringLines = stringBuilder.toString();
        String newString = removeComments(stringLines);
        String [] arrayStrings=newString.split("\n");
        /*
        Создам метод для нахождения и удаления многострочного комментария.
        С помощью цикла передаем в метод строку из коллекции.
         */
        for(String element:arrayStrings){
            System.out.println(element);
        }

        String textPath = getStringPath(TaskB.class, "TaskB.txt");
        try (PrintWriter printWriter = new PrintWriter(textPath)) {
            for(String element:arrayStrings){
                printWriter.println(element);
            }
        } catch (FileNotFoundException e) {
            // выбрасывает новое исключение
            throw new RuntimeException(e);
        }
    }
    
    private static String removeComments(String line) {
        try {
            while (line.contains("//")) {
                int start = line.indexOf("//");
                int end = line.indexOf("\n", start);
                String newLine = line.substring(start, end);
                line = line.replace(newLine, "");
            }
            while (line.contains("/*")  &&  line.contains("*/")) {
                int start = line.indexOf("/*");
                int end = line.indexOf("*/");
                String newLine = line.substring(start, end+2);
                line = line.replace(newLine, "");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return line;
    }


    private static String getStringPath(Class<?> bClass, String fileName) {
        String root = System.getProperty("user.dir");
        System.out.println(root);
        bClass = TaskB.class;
        String className = bClass.getName();
        String packageName = className.replace(bClass.getSimpleName(), "");
        String packagePath = packageName.replace(".", File.separator);
        String result = root + File.separator + "src" + File.separator + packagePath + fileName;
        System.out.println(result);
        return result;
    }
}
