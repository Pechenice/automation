package controls;

import core.Driver;
import org.openqa.selenium.By;

public class ButtonControl extends BaseControl {

    public ButtonControl(By by) {
        super(by);
    }

    public static ButtonControl findButtonById(String id) {
        return new ButtonControl(By.id(id));
    }

    public static ButtonControl findButtonByName(String name) {
        return new ButtonControl(By.name(name));
    }

    public static ButtonControl findButtonByClassName(String className) {
        return new ButtonControl(By.className(className));
    }

    public static ButtonControl findButtonByTagName(String tagName) {
        return new ButtonControl(By.tagName(tagName));
    }

    public static ButtonControl findButtonByLinkText(String linkText) {
        return new ButtonControl(By.linkText(linkText));
    }

    public static ButtonControl findButtonByPartText(String partText) {
        return new ButtonControl(By.partialLinkText(partText));
    }

    public static ButtonControl findButtonByCss(String css) {
        return new ButtonControl(By.cssSelector(css));
    }

    public static ButtonControl findButtonByXpath(String xpath) {
        return new ButtonControl(By.xpath(xpath));
    }
}
