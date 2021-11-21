package by.it.marukovich.jd01_15;

import java.io.*;
import java.util.ArrayList;

public class RepoMatrixImpl implements RepoMatrix {

    private final String filename;

    public RepoMatrixImpl(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean save(int[][] matrix) {
        try (PrintWriter printWriter = new PrintWriter(filename)) {
            for (int[] row : matrix) {
                for (int element : row) {
                    printWriter.printf("%3d ", element);
                }
                printWriter.println();
            }
        } catch (FileNotFoundException e) {
            throw new RepositoryException(e);
        }
        return false;
    }

    @Override
    public int[][] load() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            //1 -15 15 -1
            ArrayList<String> lines = new ArrayList<>();
            for (; ; ) {
                String line = bufferedReader.readLine();
                if (line != null && !line.isEmpty()) {
                    lines.add(line);
                } else {
                    break;
                }
            }
            int[][] array = new int[lines.size()][0];
            for (int i = 0; i < lines.size(); i++) {
                String row = lines.get(i).trim();
                String[] parts = row.split("\\s+");
                array[i] = new int[parts.length];
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = Integer.parseInt(parts[j]);
                }
            }
            return array;
        } catch (IOException e) {
            throw new RepositoryException(e);
        }
    }
}
