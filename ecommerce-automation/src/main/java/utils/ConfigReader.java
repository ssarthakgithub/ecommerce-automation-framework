package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    public static void loadProperties() {

        try {

            FileInputStream file =
                    new FileInputStream(
                            "src/main/resources/config.properties"
                    );

            properties = new Properties();

            properties.load(file);

            file.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {

        return properties.getProperty(key);
    }
}