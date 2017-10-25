package core;

import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class PropertiesContainer {
    private static String property;

    public static PropertiesContainer get() {
        some_search

        Map<String, String> loadedProperties = (Map<String,String> properties.lo);

        return new PropertiesContainer();
    }

    private void init() {
        Properties properties = new Properties();
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream("test.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }



}
