package controls;

import core.Driver;

import static core.Locators.get;

public class TextControl extends BaseControl {

    private TextControl() {}

    public static TextControl findTextByLocator(String locator) {
        TextControl tc = new TextControl();
        tc.element = Driver.get().findElement(get(locator));
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
