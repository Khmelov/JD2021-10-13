package by.it.antipov.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class TaskA {

    public static void main(String[] args) {
        StringBuilder root = new StringBuilder(System.getProperty("user.dir"));
        String partTwo = TaskA.class.getName().replace(".",File.separator).replace("TaskA","");
        root.append(File.separator+"src"+File.separator+partTwo+File.separator+"dataTaskA.bin");
        System.out.println(root);
        StringBuilder root2 =new StringBuilder(System.getProperty("user.dir"));
        root2.append(File.separator+"src"+File.separator+partTwo+File.separator+"resultTaskA.txt");
        File dataTaskA = new File(String.valueOf(root));
        File resultTaskA = new File (String.valueOf(root2));
        recordingInt(dataTaskA);
        List<Integer> list = new ArrayList<>();
        double sum = 0;
        int counter=0;
        double average = 0;
        try (DataInputStream readIntegers= new DataInputStream(new BufferedInputStream(new FileInputStream(dataTaskA)))){
            while (readIntegers.available()>0){
                int a=readIntegers.readInt();
                list.add(a);
                System.out.print(a+" ");
                sum=sum+a;
                counter++;
            }
            System.out.println(list);
           average= sum/counter;
            System.out.println("avg="+average);
        } catch (FileNotFoundException e) {
            System.out.println("file not found"+e);
        } catch (IOException e) {
            System.out.println("smth wrong with file");
        }
     try (PrintWriter writeIntegers = new PrintWriter(resultTaskA)) {
         writeIntegers.write(String.valueOf(list)+"\n");
         writeIntegers.write(String.valueOf(average));
     } catch (FileNotFoundException e) {
         System.out.println("file not found"+e);
     }


    }
    
    private static void recordingInt(File dataTaskA) {
        try(DataOutputStream integers= new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataTaskA)))) {
            for (int i = 0; i <20 ; i++) {
                integers.writeInt((int) (Math.random()*21));
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found"+e);
        } catch (IOException e) {
            System.out.println("smth wrong with file");
        }
    }
}
