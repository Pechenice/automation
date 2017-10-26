package controls;

import core.Driver;
import org.openqa.selenium.By;

public class ButtonControl extends BaseControl {

    public static ButtonControl findButtonById(String id) {
        ButtonControl bc = new ButtonControl();
        bc.element = Driver.get().findElement(By.id(id));
        return bc;
    }

    public static ButtonControl findButtonByName(String name) {
        ButtonControl bc = new ButtonControl();
        bc.element = Driver.get().findElement(By.name(name));
        return bc;
    }

    public static ButtonControl findButtonByClassName(String className) {
        ButtonControl bc = new ButtonControl();
        bc.element = Driver.get().findElement(By.className(className));
        return bc;
    }

    public static ButtonControl findButtonByTagName(String tagName) {
        ButtonControl bc = new ButtonControl();
        bc.element = Driver.get().findElement(By.tagName(tagName));
        return bc;
    }

    public static ButtonControl findButtonByLinkText(String linkText) {
        ButtonControl bc = new ButtonControl();
        bc.element = Driver.get().findElement(By.linkText(linkText));
        return bc;
    }

    public static ButtonControl findButtonByPartText(String partText) {
        ButtonControl bc = new ButtonControl();
        bc.element = Driver.get().findElement(By.partialLinkText(partText));
        return bc;
    }

    public static ButtonControl findButtonByCss(String css) {
        ButtonControl bc = new ButtonControl();
        bc.element = Driver.get().findElement(By.cssSelector(css));
        return bc;
    }

    public static ButtonControl findButtonByXpath(String xpath) {
        ButtonControl bc = new ButtonControl();
        bc.element = Driver.get().findElement(By.xpath(xpath));
        return bc;
    }
}
