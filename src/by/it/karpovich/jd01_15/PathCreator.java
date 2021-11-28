package by.it.karpovich.jd01_15;

import java.io.File;

class PathCreator {

    public static final String USER_DIR = "user.dir";
    public static final String SRC = "src";

    private PathCreator() {
    }

    static String getFileName(Class<?> aClass, String fileName) {

        String workingDirectory = System.getProperty(USER_DIR);
        String path = aClass.getName()
                .replace(aClass.getSimpleName(), "")
                .replace(".", File.separator);
        return workingDirectory + File.separator + SRC + File.separator + path + fileName;
    }
}