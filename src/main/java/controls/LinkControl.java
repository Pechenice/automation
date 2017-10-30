package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LinkControl extends BaseControl {

    public LinkControl(By by) {
        super(by);
    }

    public LinkControl(WebElement element, By by) {
                super(element, by);
    }

    public static LinkControl findLinkById(String id) {
        return new LinkControl(By.id(id));
    }

    public static LinkControl findLinkByName(String name) {
        return new LinkControl(By.name(name));
    }

    public static LinkControl findLinkByClassName(String className) {
        return new LinkControl(By.className(className));
    }

    public static LinkControl findLinkByTagName(String tagName) {
        return new LinkControl(By.tagName(tagName));
    }

    public static LinkControl findLinkByLinkText(String linkText) {
        return new LinkControl(By.linkText(linkText));
    }

    public static LinkControl findLinkByPartText(String partText) {
        return new LinkControl(By.partialLinkText(partText));
    }

    public static LinkControl findLinkByCss(String css) {
        return new LinkControl(By.cssSelector(css));
    }

    public static LinkControl findLinkByXpath(String xpath) {
        return new LinkControl(By.xpath(xpath));
    }

    public static LinkControl findLinkByXpath(WebElement element, String xpath) {
        return new LinkControl(element, By.xpath(xpath));
    }

    public String getUrl () {
        return element.getAttribute("href");
    }

}
