package pages;

import controls.TextControl;
import core.Driver;

public class BasePage {
    TextControl title;

    BasePage() {
        title = TextControl.findTextByCss("head title");
    }

    public String getTitleText() {
        return title.getText();
    }

    public String getCurrentUrl() {
        return Driver.get().getCurrentUrl();
    }
}
