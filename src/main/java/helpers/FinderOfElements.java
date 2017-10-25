package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static core.Driver.get;

public class FinderOfElements {

    public static WebElement findElement(By locator) {
        return get().findElement(locator);
    }

    public static List<WebElement> findElements(By locator) {
        return get().findElements(locator);
    }

    public static void open(String url) {
        get().navigate().to(url);
    }
}
