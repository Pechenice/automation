package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Link extends Base {

    public static Link byId(String id) {
        return new Link(By.id(id));
    }
    public static Link byName(String name) {
        return new Link(By.name(name));
    }
    public static Link byClassName(String className) {
        return new Link(By.className(className));
    }
    public static Link byTagName(String tagName) {
        return new Link(By.tagName(tagName));
    }
    public static Link byLinkText(String linkText) {
        return new Link(By.linkText(linkText));
    }
    public static Link byPartText(String partText) {
        return new Link(By.partialLinkText(partText));
    }
    public static Link byCss(String css) {
        return new Link(By.cssSelector(css));
    }
    public static Link byXpath(String xpath) {
        return new Link(By.xpath(xpath));
    }
    public static Link byXpath(WebElement element, String xpath) {
        return new Link(element, By.xpath(xpath));
    }

    public Link(By by) {
        super(by);
    }

    public Link(WebElement element, By by) {
                super(element, by);
    }

    public String getAttribute (String attribute) {
        return element.getAttribute(attribute);
    }

}
