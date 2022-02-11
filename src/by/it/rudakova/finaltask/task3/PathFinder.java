package by.it.rudakova.finaltask.task3;

import java.io.File;

public class PathFinder implements PathFinderInterface {

    public String getStringPath(Class<?> carClass, String filename) {
        String root = System.getProperty("user.dir");
        System.out.println(root);
        String className = carClass.getName();
        String packageName = className.replace(carClass.getSimpleName(), "");
        String packagePath = packageName.replace(".", File.separator);
        return  root + File.separator + "src" + File.separator + packagePath + filename;
    }
}
