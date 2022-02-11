package by.it.ena.jd02_06;

import java.io.File;

class PathFinderImpl implements PathFinder {

    public String getStringPath(Class<?> cl, String fileName) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir;
        clDir = cl.getName().replace(cl.getSimpleName(), "")
                .replace(".", File.separator);
        return path + clDir + fileName;
    }
}
