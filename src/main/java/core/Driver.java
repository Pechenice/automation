package core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver = null;

    private Driver() {
        //block constructor
    }

    public static WebDriver get() {
        return driver;
    }

    protected static void init() {
        if (Driver.driver == null) {
            switch (PropertiesContainer.get("test.browser")) {
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
        }
    }

    public static void quit() {
        if (driver != null) {
            Driver.get().quit();
            driver = null;
        }
    }
}
