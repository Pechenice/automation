package controls;

import core.Driver;
import org.openqa.selenium.By;

public class TextControl extends BaseControl {

    private TextControl() {
    }

    public static TextControl findTextById(String id) {
        TextControl tc = new TextControl();
        tc.element = Driver.get().findElement(By.id(id));
        return tc;
    }

    public static TextControl findTextByName(String name) {
        TextControl tc = new TextControl();
        tc.element = Driver.get().findElement(By.name(name));
        return tc;
    }

    public static TextControl findTextByClassName(String className) {
        TextControl tc = new TextControl();
        tc.element = Driver.get().findElement(By.className(className));
        return tc;
    }

    public static TextControl findTextByTagName(String tagName) {
        TextControl tc = new TextControl();
        tc.element = Driver.get().findElement(By.tagName(tagName));
        return tc;
    }

    public static TextControl findTextByLinkText(String linkText) {
        TextControl tc = new TextControl();
        tc.element = Driver.get().findElement(By.linkText(linkText));
        return tc;
    }

    public static TextControl findTextByPartText(String partText) {
        TextControl tc = new TextControl();
        tc.element = Driver.get().findElement(By.partialLinkText(partText));
        return tc;
    }

    public static TextControl findTextByCss(String css) {
        TextControl tc = new TextControl();
        tc.by = By.cssSelector(css);
        tc.element = Driver.get().findElement(tc.by);
        return tc;
    }

    public static TextControl findTextByXpath(String xpath) {
        TextControl tc = new TextControl();
        tc.element = Driver.get().findElement(By.xpath(xpath));
        return tc;
    }

    public void clear() {
        element.clear();
    }

    public void sendKeys(String text) {
        clear();
        element.sendKeys(text);
    }

}
