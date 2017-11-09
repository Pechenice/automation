package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Button extends Base {

    public static Button byId(String id) {
        return new Button(By.id(id));
    }
    public static Button byName(String name) {
        return new Button(By.name(name));
    }
    public static Button byClassName(String className) {
        return new Button(By.className(className));
    }
    public static Button byXpath(WebElement element, String className) {
        return new Button(element, By.xpath(className));
    }
    public static Button byTagName(String tagName) {
        return new Button(By.tagName(tagName));
    }
    public static Button byLinkText(String linkText) {
        return new Button(By.linkText(linkText));
    }
    public static Button byPartText(String partText) {
        return new Button(By.partialLinkText(partText));
    }
    public static Button byCss(String css) {
        return new Button(By.cssSelector(css));
    }
    public static Button byXpath(String xpath) {
        return new Button(By.xpath(xpath));
    }

    public Button(By by) {
        super(by);
    }

    public Button(WebElement element, By by) {
        super(element, by);
    }

    public void sendKeys(String keys) { element.sendKeys(keys);}
}
