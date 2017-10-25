package core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
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
        if (Driver.driver == null) {
            switch (PropertiesContainer.get("test.browser"))  {
                case "chrome":
                    ChromeDriverManager.getInstance().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    FirefoxDriverManager.getInstance().setup();
                    driver = new FirefoxDriver();
                    break;
                case "iexplore":
                    InternetExplorerDriverManager.getInstance().setup();
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
