package by.it.ena.jd01_14;

import java.io.File;

public class PathFinder {

    private PathFinder() {

    }

    public static String getStringPath(Class<?> cl, String fileName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir;
        clDir = cl.getName().replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return path + clDir + fileName;
    }
}
