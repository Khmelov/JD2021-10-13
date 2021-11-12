//package by.it.karmyzov.jd01_14;
//
//import java.io.File;
//import java.io.FileOutputStream;
//
//public class TaskA {
//    public static void main(String[] args) {
//        getStPath (TaskA.class, "dataTaskA.bin");
//        // new FileOutputStream()
//    }
//
//    private static void getPath(Class<? aClass, String filemame)
//    {
//        String root = System.getProperty("user.dir");
//        System.out.println(root);
//        Class<?> aClass = TaskA.class;
//        String className = aClass.getName();
//        String packageName = className.replace(aClass.getSimpleName(), "");
//        String packagePath = packageName.replace(".",File.separator);
//        String path = root + File.separator+"src"+File.separator+packagePath;
//        System.out.println(path);
//        return; path+filemame;
//    }
//}
