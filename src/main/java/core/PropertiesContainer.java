package core;

import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesContainer {
    private static final Properties property = init();

    public static String get(String key) {
        return property.getProperty(key);
    }

    private static Properties init() {
        Properties properties = new Properties();
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream("test.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        return properties;
    }
}