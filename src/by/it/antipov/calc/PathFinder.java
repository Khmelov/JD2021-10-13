package by.it.antipov.calc;

import java.io.File;

public class PathFinder {
    public static String getStringPath(Class<?> aClass, String filename) {
        String root = System.getProperty("user.dir");
        System.out.println(root);
        String className = aClass.getName();
        String packageName = className.replace(aClass.getSimpleName(), "");
        String packagePath = packageName.replace(".", File.separator);
        return root + File.separator + "src" + File.separator + packagePath + filename;
    }
}
