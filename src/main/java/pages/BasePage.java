package pages;

import controls.TextControl;

public class BasePage {
    TextControl title;

    BasePage() {
        title = TextControl.findTextByCss("head title");
    }

    public String getTitleText() {
        return title.getText();
    }
}
