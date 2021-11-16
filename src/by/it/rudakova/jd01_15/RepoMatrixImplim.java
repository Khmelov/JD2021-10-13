package by.it.rudakova.jd01_15;

import by.it._classwork_.jd01_15.RepositoryException;

import java.io.*;
import java.util.ArrayList;

public class RepoMatrixImplim implements RepoMatrix{
    private final String fileName;
    public RepoMatrixImplim(String fileName){
        this.fileName=fileName;
    }
    @Override
    public boolean save(int[][] matrix) {
        try(PrintWriter printWriter=new PrintWriter(fileName)){
            for(int [] row:matrix){
                for(int element:row){
                    printWriter.printf("%3d ",element);
                }
                printWriter.println();
            }
        }catch (FileNotFoundException e){
            throw new RepositoryException(e);
        }
        return false;
    }

    @Override
    public int[][] load() {
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader(fileName))){
            ArrayList<String> lines=new ArrayList<>();
            while(true){
                String line=bufferedReader.readLine();
                if(line!=null&&!line.isEmpty()){
                    lines.add(line);
                }
                else {
                    break;
                }
            }
            int [][] array=new int[lines.size()][0];
            for(int i=0;i<lines.size();i++){
                String row=lines.get(i).trim();
                String[] parts=row.split("\\s+");
                array[i]=new int[parts.length];
                for(int j=0;j<array[i].length;j++){
                    array[i][j]=Integer.parseInt(parts[j]);
                }
            }
            return array;

        } catch (IOException e){
            throw new RepositoryException(e);
        }
    }
}
