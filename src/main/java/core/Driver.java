package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver = null;

    public Driver() {
        //block constructor
    }

    public static WebDriver get() {
        return driver;
    }

    protected static void init() {
        Properties properties = new Properties();
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream("test.properties");
            properties.load(inputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
            Assert.fail(exception.getMessage());
        }
        @SuppressWarnings("unchecked")
        Enumeration<String> propertyNames = (Enumeration<String>) properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String key = propertyNames.nextElement();
            System.setProperty(key, properties.getProperty(key));
            Reporter.log(key + " - " + properties.getProperty(key), 2, true);
        }

        if (Driver.driver == null) {
            switch (System.getProperty("test.browser"))  {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chrome/chromedriver.exe");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "src/main/resources/chrome/firefox/geckodriver.exe");
                    driver = new FirefoxDriver();
                    break;
                case "iexplore":
                    System.setProperty("webdriver.ie.driver", "src/main/resources/chrome/ie/IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new AssertionError("Unsupported browser " + System.getProperty("test.browser"));
            }
            Driver.driver.manage().timeouts().implicitlyWait(Long.parseLong(System.getProperty("test.timeouts")), TimeUnit.SECONDS);
        }
    }

    public static void quit() {
        if (driver != null) {
            Driver.get().quit();
            driver = null;
        }
    }
}
