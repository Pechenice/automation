package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Text extends Base {
    public static Text byId(String id) {
        return new Text(By.id(id));
    }
    public static Text byName(String name) {
        return new Text(By.name(name));
    }
    public static Text byClassName(String className) {
        return new Text(By.className(className));
    }
    public static Text byTagName(String tagName) {
        return new Text(By.tagName(tagName));
    }
    public static Text byLinkText(String linkText) {
        return new Text(By.linkText(linkText));
    }
    public static Text byPartText(String partText) {
        return new Text(By.partialLinkText(partText));
    }
    public static Text byCss(String css) {
        return new Text(By.cssSelector(css));
    }
    public static Text byXpath(String xpath) {
        return new Text(By.xpath(xpath));
    }

    public Text(By by) {
        super(by);
    }

    public void clear() {
        element.clear();
    }

    public void sendKeys(String text) {
        clear();
        element.sendKeys(text);
    }

    public void pressEnter() {
        element.sendKeys(Keys.ENTER);
    }
}
