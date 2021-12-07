package by.it.antipov.jd01_15;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        StringBuilder root = new StringBuilder(System.getProperty("user.dir"));
        String partTwo2 = TaskC.class.getName()
                .replace(".", File.separator)
                .replace("\\TaskC", "");
        root.append(File.separator + "src" + File.separator +partTwo2);
        File file =new File(String.valueOf(root));

        Scanner scanner = new Scanner(System.in);
        for (;;){
           System.out.println(file.getAbsolutePath()+">");
//            for (File subFile: Objects.requireNonNull(file.listFiles())){
//                System.out.println(subFile.getName());
//            }
          // System.out.println(Arrays.toString(file.listFiles()));
            String expression =scanner.nextLine();
file=command(expression,file);
if (Objects.equals(expression, "end")) break;
        }
    }

    public static File command(String expression,File file){
        System.out.println(Arrays.toString(file.listFiles()));
        if (Objects.equals(expression, "cd ..")){file=file.getParentFile();}
       else if ((file.isDirectory())&&(Objects.equals(expression, "dir"))){
            for (File subFile: Objects.requireNonNull(file.listFiles())) {
                System.out.println(new Date(subFile.lastModified())+"   "+subFile.getName());
            }}
     else if (Objects.nonNull(file.listFiles())){for (File subFile: Objects.requireNonNull(file.listFiles())) {
            if(Objects.equals(expression,"cd "+subFile.getName())){file=new File(file.getPath()+File.separator+subFile.getName());}
            if (Objects.nonNull(subFile.listFiles())){ for (File subSubFiles: Objects.requireNonNull(subFile.listFiles())) {
                if(Objects.equals(expression,"cd "+subSubFiles.getName())){file=new File(file.getPath()+File.separator+subFile.toString()+File.separator+subSubFiles.toString());}
            }}
     }}
        System.out.println(Arrays.toString(file.listFiles()));




        return file;
    }

}
