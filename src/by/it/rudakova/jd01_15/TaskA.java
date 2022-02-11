package by.it.rudakova.jd01_15;


import java.io.PrintWriter;
import java.util.Random;

public class TaskA {

    public static final  int MIN=-15;
    public static final  int MAX=15;

    public static void main(String[] args) {
        PathFinder pathFinder=new PathFinder();
        int [][] array=new int [6][4];
        fillArray(array,MIN,MAX);
        String fileName= pathFinder.getStringPath(TaskA.class,"matrix.txt");
        RepoMatrix repoMatrix=new RepoMatrixImplim(fileName);
        repoMatrix.save(array);
        int[][] arrayAfterLoad=repoMatrix.load();
        printArray(arrayAfterLoad);

    }

    // избавиться от этого статика
    private static void fillArray(int[][] array, int min, int max) {
        Random random =new Random();
        for(int[] row:array){
            for(int i=0;i<row.length;i++){
                row[i]=min+random.nextInt(max-min+1);
            }
        }
    }
    private static void printArray(int[][] arrayAfterLoad) {
        for (int[] row : arrayAfterLoad) {
            for (int element : row) {
                System.out.printf("%3d ", element);
            }
        }
    }
}
