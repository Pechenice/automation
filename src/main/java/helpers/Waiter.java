package helpers;

import core.Driver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    private static final int timeout = Integer.parseInt(System.getProperty("test.timeout"));

    public static void waitFor (ExpectedCondition condition) {
        new WebDriverWait(Driver.get(), timeout).until(condition);
    }
}
