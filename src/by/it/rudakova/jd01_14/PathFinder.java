package by.it.rudakova.jd01_14;

import java.io.File;

public class PathFinder {

    public static String getStringPath(Class<?> aClass, String filename) {
        String root = System.getProperty("user.dir");
        System.out.println(root);
        aClass = TaskA.class;
        String className = aClass.getName();
        String packageName = className.replace(aClass.getSimpleName(), "");
        String packagePath = packageName.replace(".", File.separator);
        String result = root + File.separator + "src" + File.separator + packagePath + filename;
        System.out.println(result);
        return result;
    }
}
