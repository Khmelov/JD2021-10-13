package by.it._classwork_.jd01_14;

import java.io.File;

public class PathFinder {

    private PathFinder() {
    }

    public static String getStringPath(Class<?> aClass, String filename) {
        String root = System.getProperty("user.dir");
        System.out.println(root);
        String className = aClass.getName();
        String packageName = className.replace(aClass.getSimpleName(), "");
        String packagePath = packageName.replace(".", File.separator);
        return root + File.separator + "src" + File.separator + packagePath + filename;
    }
}
