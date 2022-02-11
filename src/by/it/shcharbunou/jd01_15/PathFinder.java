package by.it.shcharbunou.jd01_15;

import java.io.File;

public class PathFinder {

    protected PathFinder() {
    }

    public String getStringPath(Class<?> aClass, String filename) {
        String root = System.getProperty("user.dir");
        String className = aClass.getName();
        String packageName = className.replace(aClass.getSimpleName(), "");
        String packagePath = packageName.replace(".", File.separator);
        return root + File.separator + "src" + File.separator + packagePath + filename;
    }
}
