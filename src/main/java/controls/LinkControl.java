package controls;

import core.Driver;
import org.openqa.selenium.By;

public class LinkControl extends BaseControl{

    public static LinkControl findLinkById(String id) {
        LinkControl lc = new LinkControl();
        lc.element = Driver.get().findElement(By.id(id));
        return lc;
    }
    public static LinkControl findLinkByName(String name) {
        LinkControl lc = new LinkControl();
        lc.element = Driver.get().findElement(By.name(name));
        return lc;
    }
    public static LinkControl findLinkByClassName(String className) {
        LinkControl lc = new LinkControl();
        lc.element = Driver.get().findElement(By.className(className));
        return lc;
    }
    public static LinkControl findLinkByTagName(String tagName) {
        LinkControl lc = new LinkControl();
        lc.element = Driver.get().findElement(By.tagName(tagName));
        return lc;
    }
    public static LinkControl findLinkByLinkText(String linkText) {
        LinkControl lc = new LinkControl();
        lc.element = Driver.get().findElement(By.linkText(linkText));
        return lc;
    }
    public static LinkControl findLinkByPartText(String partText) {
        LinkControl lc = new LinkControl();
        lc.element = Driver.get().findElement(By.partialLinkText(partText));
        return lc;
    }
    public static LinkControl findLinkByCss(String css) {
        LinkControl lc = new LinkControl();
        lc.element = Driver.get().findElement(By.cssSelector(css));
        return lc;
    }
    public static LinkControl findLinkByXpath(String xpath) {
        LinkControl lc = new LinkControl();
        lc.element = Driver.get().findElement(By.xpath(xpath));
        return lc;
    }

}
