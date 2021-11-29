package by.it.oliakhevich.jd01_15;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
    public static void main(String[] args) {
        TaskA matrixFiller = new TaskA();
        TaskA matrixMover = new TaskA();
        TaskA matrixReader = new TaskA();
        Integer[][] matrix = new Integer[6][4];
        Integer[][] returnedMatrix;
        Integer[][] filledMatrix = matrixFiller.fillMatrix(matrix, -15, 15);
        System.out.println(Arrays.deepToString(filledMatrix));
        String path = matrixMover.moveFilledMatrixTo(filledMatrix, "matrix.txt");
        readMatrix(path);

    }

    public static void readMatrix(String path) {
        File file1 = new File(path);
        // Integer [][] returnedMatrix = Integer[][];
        String strMatrix;
        try (BufferedReader reader = new BufferedReader((new FileReader(file1)))) {
            for (; ; ) {
                strMatrix = reader.readLine();
                if ((strMatrix != null) && (!strMatrix.isEmpty())) {
                    System.out.println(strMatrix);
                } else break;
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found" + e);
        } catch (IOException e) {
            System.out.println("sumthihg wrong with file");
        }
    }


    public String moveFilledMatrixTo(Integer[][] filledMatrix, String fileName) {
        String path = System.getProperty("user.dir");
        path = path + File.separator + "src" + File.separator + TaskA.class.getName().replace(".", File.separator).replace("TaskA", "") + fileName;
        System.out.println(path);
        File file = new File(path);
        StringBuilder stringMatrix = new StringBuilder();
        for (int i = 0; i < filledMatrix.length; i++) {
            for (int j = 0; j < filledMatrix[0].length; j++) {
                stringMatrix.append(String.format("%3d ", filledMatrix[i][j]));
            }
            stringMatrix.append("\n");
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(String.valueOf(stringMatrix));
        } catch (IOException e) {
            System.out.println("smth wrong with file");
        }
        return path;
    }

    public Integer[][] fillMatrix(Integer[][] matrix, int min, int max) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = min + random.nextInt(max - min + 1);
            }
        }
        return matrix;
    }
}
