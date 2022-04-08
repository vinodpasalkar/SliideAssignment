package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private final static String pathToConfigFile = "config.properties";
    private static Properties properties = null;
    private static String filePointer = "";

    private static void setProperties(String fileName) throws
            IOException {
        properties = new Properties();
        if (pathToConfigFile.contains(fileName)) {
            properties.load(new FileInputStream(pathToConfigFile));
            filePointer = pathToConfigFile;
        }
    }

    public static String getProperty(String fileName, String key) {
        if (!(properties != null && filePointer.contains(fileName))) {
            try {
                setProperties(fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty(key);
    }
}
