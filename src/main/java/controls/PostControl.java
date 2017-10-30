package controls;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PostControl {
    private List<WebElement> listOfElements;

    public PostControl (By by) {
        listOfElements = Driver.get().findElements(by);
    }

    public static PostControl findElementsByClassName (String className) {
        return new PostControl(By.className(className));
    }

    public List<WebElement> getListOfElements() {
        return listOfElements;
    }
}
